package com.hvlv.microservices.apiService.hvlvApiService.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.apiService.hvlvApiService.alliedTest.*;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;
import com.hvlv.microservices.apiService.hvlvApiService.client.LabelClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;

@Service
public class AlliedService extends HvlvService implements AlliedInterface{
    private List<String> pregMatchs;
    private Matcher m;
    private String signatureKey;
    private String accountCode;
    private String url;

    @Autowired
    LabelClient labelClient;

    @Autowired
    RedisService redisService;

    public AlliedService() {
        pregMatchs = new ArrayList<String>();
        signatureKey = "2d056925bea6a97471fbb33348a25bd5";
        accountCode = "TOPLOG";
        url = "http://triton.alliedexpress.com.au:8080/ttws-ejb/TTWS";
    }

    public JsonResultBean createAlliedShipment(JSONObject jsonData)
    {
        JsonResultBean labelResult = labelClient.generateRefByPrefix("{\"prefix\":\""+jsonData.getString("prefix")+"\",\"orgId\":4429}");
        if(labelResult.isSuccess())
        {
            JSONObject data = (JSONObject) labelResult.getData();
            Integer pkg = jsonData.getInteger("packs");
            String[] barcodes = new String[pkg];
            for (int i = 0; i < pkg; i++) {
                barcodes[i] = data.getString("ref")+"-"+String.format("%03d", i+1);
            }
            data.put("barcode", StringUtils.join(barcodes, ","));
            labelResult.setData(data);
        }
        return labelResult;
    }

    public JsonResultBean manifestAllied(JSONObject jsonData)
    {
        JsonResultBean result = new JsonResultBean();
        try
        {
            // Create the web service object
            URL portAddress = new URL(this.url);
            TnTWebService service = new TnTWebServiceLocator();
            TTWS ttws = service.getTTWSPort(portAddress);
            JSONObject shipper = jsonData.getJSONObject("shipper");
            // Get the account to use
            Account account = ttws.getAccountDefaults(this.signatureKey,
                    this.accountCode,
                    shipper.getString("state"),
                    "AOE");
            // Construct the job stop objects

            JSONObject consignee = jsonData.getJSONObject("consignee");

            GeographicAddress pickupAddress = new GeographicAddress();
            pickupAddress.setAddress1(shipper.getString("address"));
            pickupAddress.setSuburb(shipper.getString("suburb"));
            pickupAddress.setState(shipper.getString("state"));
            pickupAddress.setPostCode(shipper.getString("postcode"));

            GeographicAddress deliveryAddress = new GeographicAddress();
            deliveryAddress.setAddress1(consignee.getString("address"));
            deliveryAddress.setSuburb(consignee.getString("suburb"));
            deliveryAddress.setState(consignee.getString("state"));
            deliveryAddress.setPostCode(consignee.getString("postcode"));


            JobStop pickupStop = new JobStop();
            pickupStop.setCompanyName(shipper.getString("company"));
            pickupStop.setContact(shipper.getString("name"));
            pickupStop.setGeographicAddress(pickupAddress);
            pickupStop.setPhoneNumber(shipper.getString("phone"));
            pickupStop.setStopType("P");
            pickupStop.setStopNumber(1);
            JobStop deliveryStop = new JobStop();
            deliveryStop.setCompanyName(consignee.getString("company"));
            deliveryStop.setContact(consignee.getString("name"));
            deliveryStop.setGeographicAddress(deliveryAddress);
            deliveryStop.setPhoneNumber(consignee.getString("phone"));
            deliveryStop.setStopType("D");
            deliveryStop.setStopNumber(2);
            JobStop[] jobStops = new JobStop[] { pickupStop, deliveryStop };
            // Construct the Item objects
            JSONArray items = jsonData.getJSONArray("packages");
            Item[] jobItems = new Item[items.size()];
            for (int i=0;i<jobItems.length;i++)
            {
                Item jobItem1 = new Item();
                jobItem1.setDangerous(false);
                jobItem1.setLength(Double.parseDouble(items.getJSONObject(i).getString("length"))); // in centi meter
                jobItem1.setWidth( Double.parseDouble(items.getJSONObject(i).getString("width"))); // in centi meter
                jobItem1.setHeight(Double.parseDouble(items.getJSONObject(i).getString("height"))); // in centi meter
                jobItem1.setVolume(Double.parseDouble(items.getJSONObject(i).getString("cbm"))); // in centi meter
                jobItem1.setWeight(Double.parseDouble(items.getJSONObject(i).getString("weight"))); // in centi meter
                jobItem1.setItemCount(1); // in centi meter
                jobItems[i] = jobItem1;
            }

            // Construct the reference number array
            String[] referenceNumbers = new String[] { (String)jsonData.get("hbn") };
            // Create the ready date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s");
            Date date = dateFormat.parse((String)jsonData.get("date"));
            Calendar readyDate = Calendar.getInstance();
            readyDate.setTime(date);


            // Get the total items, weight and volume from the Items array
            int totalItems = 0;
            int totalWeight = 0;
            double totalVolume = 0.000D;
            for (Item item : jobItems)
            {
                totalItems += item.getItemCount();
                totalWeight += item.getWeight() * item.getItemCount();
                totalVolume += item.getVolume() * item.getItemCount();
            }
            // Construct the Job object
            Job job = new Job();
            job.setAccount(account);
            job.setInstructions(jsonData.getString("instruction")); // Optional
            job.setItemCount(totalItems);
            job.setWeight(totalWeight);
            job.setVolume(totalVolume);
            job.setItems(jobItems);
            job.setJobStops(jobStops);
            job.setServiceLevel("R");
            job.setReferenceNumbers(referenceNumbers); // Optional
            job.setBookedBy(shipper.getString("name"));
            job.setReadyDate(readyDate);
            job.setDocketNumber(jsonData.getString("ref"));

            job = ttws.validateBooking(this.signatureKey, job);
            // Check that there were no errors
            if (job.getJobErrors() == null || job.getJobErrors(0) == null)
            {
                ttws.savePendingJob(this.signatureKey, job);
                int jobId = job.getJobNumber();
                int[] jobIDs = new int[1];
                jobIDs[0] = jobId;
                Job[] jobs = ttws.dispatchPendingJobs(this.signatureKey, jobIDs);
                result.setSuccess();
                result.setData(job);
                return result;

            }
            else
            {
                ArrayList<String> errorStr = new ArrayList();
                // Job not validated
                for (JobError je : job.getJobErrors())
                {
                    errorStr.add (je.getErrorMsg());
                }

                result.setError();
                result.setData(errorStr);
                return result;
            }


        }catch (Exception ex)
        {
            ex.printStackTrace();
            ArrayList<String> errorStr = new ArrayList();
            errorStr.add ("Unexpected Error");
            errorStr.add ("MyAllied:"+ex.getMessage());
            result.setError();
            result.setData(errorStr);
            return result;
        }
    }

    public JsonResultBean getAlliedCharge(JSONObject jsonData)
    {
        JsonResultBean result = new JsonResultBean();
        try
        {
            JSONObject reCache = redisService.getObject(jsonData.getString("cref")+jsonData.getInteger("agent_id"));
            if(reCache!=null)
            {
                result.setSuccess();
                result.setData(reCache);
                return result;
            }

            // Create the web service object
            URL portAddress = new URL(this.url);
            TnTWebService service = new TnTWebServiceLocator();
            TTWS ttws = service.getTTWSPort(portAddress);
            // Get the account to use
            Account account = ttws.getAccountDefaults(this.signatureKey,
                    this.accountCode,
                    (String) jsonData.get("shipper_state"),
                    "AOE");
            // Construct the job stop objects
            GeographicAddress pickupAddress = new GeographicAddress();
            pickupAddress.setAddress1((String) jsonData.get("shipper_address"));
            pickupAddress.setSuburb((String) jsonData.get("shipper_suburb"));
            pickupAddress.setState((String) jsonData.get("shipper_state"));
            pickupAddress.setPostCode((String) jsonData.get("shipper_postcode"));
            GeographicAddress deliveryAddress = new GeographicAddress();
            deliveryAddress.setAddress1((String) jsonData.get("cnee_address"));
            deliveryAddress.setSuburb((String) jsonData.get("cnee_suburb"));
            deliveryAddress.setState((String) jsonData.get("cnee_state"));
            deliveryAddress.setPostCode((String) jsonData.get("cnee_postcode"));
            JobStop pickupStop = new JobStop();
            pickupStop.setCompanyName((String) jsonData.get("shipper_company"));
            pickupStop.setContact((String) jsonData.get("shipper_name"));
            pickupStop.setGeographicAddress(pickupAddress);
            pickupStop.setPhoneNumber((String) jsonData.get("shipper_tel"));
            pickupStop.setStopType("P");
            pickupStop.setStopNumber(1);
            JobStop deliveryStop = new JobStop();
            deliveryStop.setCompanyName((String) jsonData.get("cnee_company"));
            deliveryStop.setContact((String) jsonData.get("cnee_name"));
            deliveryStop.setGeographicAddress(deliveryAddress);
            deliveryStop.setPhoneNumber((String) jsonData.get("cnee_tel"));
            deliveryStop.setStopType("D");
            deliveryStop.setStopNumber(2);
            JobStop[] jobStops = new JobStop[] { pickupStop, deliveryStop };
            // Construct the Item objects
            JSONArray items = jsonData.getJSONArray("items");
            Item[] jobItems = new Item[items.size()];
            for (int i=0;i<jobItems.length;i++)
            {
                Item jobItem1 = new Item();
                jobItem1.setDangerous(false);
                jobItem1.setLength((Double) items.getJSONObject(0).get("length")); // in centi meter
                jobItem1.setWidth((Double) items.getJSONObject(0).get("width")); // in centi meter
                jobItem1.setHeight((Double) items.getJSONObject(0).get("height")); // in centi meter
                jobItem1.setVolume((Double) items.getJSONObject(0).get("cbm")); // in centi meter
                jobItem1.setWeight((Double) items.getJSONObject(0).get("weight")); // in centi meter
                jobItem1.setItemCount(1); // in centi meter
                jobItems[i] = jobItem1;
            }

            // Create the ready date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s");
            Date date = dateFormat.parse((String)jsonData.get("date"));
            Calendar readyDate = Calendar.getInstance();
            readyDate.setTime(date);


            // Get the total items, weight and volume from the Items array
            int totalItems = 0;
            int totalWeight = 0;
            double totalVolume = 0.000D;
            for (Item item : jobItems)
            {
                totalItems += item.getItemCount();
                totalWeight += item.getWeight() * item.getItemCount();
                totalVolume += item.getVolume() * item.getItemCount();
            }
            // Construct the Job object
            JobExt jobExt = new JobExt();
            Job job = new Job();
            job.setAccount(account);
            job.setInstructions((String)jsonData.get("instruction")); // Optional
            job.setItemCount(totalItems);
            job.setWeight(totalWeight);
            job.setVolume(totalVolume);
            job.setItems(jobItems);
            job.setJobStops(jobStops);
            job.setServiceLevel("R");
            job.setBookedBy((String) jsonData.get("shipper_name"));
            job.setReadyDate(readyDate);
            jobExt = ttws.validateBookingExt(this.signatureKey, jobExt);
            Double totalCharge = jobExt.getJob().getPrice().getNetPrice() +
                    jobExt.getOnForwardChargeDelivery() + jobExt.getOnForwardChargePickup() + jobExt.getFreightOversizedHomeDel();
            // Check that there were no errors
            if (jobExt.getJob().getJobErrors() == null || job.getJobErrors(0) == null)
            {
                HashMap<String,Double> re = new HashMap();
                re.put("total_price",totalCharge);
                re.put("base_price",jobExt.getJob().getPrice().getNetPrice());
                re.put("on_forward_charge_delivery",jobExt.getOnForwardChargeDelivery());
                re.put("on_forward_charge_pickup",jobExt.getOnForwardChargePickup());
                re.put("freight_oversized_home_del",jobExt.getFreightOversizedHomeDel());
                redisService.setKey(jsonData.getString("cref")+jsonData.getInteger("agent_id"), JSONObject.toJSONString(re),30);
                result.setSuccess();
                result.setData(re);
                return result;
            }
            else
            {
                ArrayList<String> errorStr = new ArrayList();
                // Job not validated
                for (JobError je : jobExt.getJob().getJobErrors())
                {
                    errorStr.add (je.getErrorMsg());
                }

                result.setError();
                result.setData(errorStr);
                return result;
            }


        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        ArrayList<String> errorStr = new ArrayList();
        errorStr.add ("Unexpected Error");
        result.setError();
        result.setData(errorStr);
        return result;
    }

    public JsonResultBean trackAllied(JSONObject jsonData)
    {
        JsonResultBean result = new JsonResultBean();
        try
        {
            // Create the web service object
            URL portAddress = new URL(this.url);
            TnTWebService service = new TnTWebServiceLocator();
            TTWS ttws = service.getTTWSPort(portAddress);
            JSONObject consignee = jsonData.getJSONObject("consignee");
            // Get the account to use
            Job job = ttws.getJobDetails(this.signatureKey,"AOE",jsonData.getString("ref"),"",consignee.getString("postcode"));
            // extract all job stops
            Scanning[] scan = job.getScannings();

            if (scan!=null&&scan.length>0)
            {
                HashMap<String,Scanning[]> re = new HashMap();
                re.put("tracking_data",scan);
                result.setSuccess();
                result.setData(re);
                return result;
            }
            else
            {
                ArrayList<String> errorStr = new ArrayList();
                errorStr.add("Without Tracking");
                result.setError();
                result.setData(errorStr);
                return result;
            }


        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        ArrayList<String> errorStr = new ArrayList();
        errorStr.add ("Unexpected Error");
        result.setError();
        result.setData(errorStr);
        return result;
    }

    public JsonResultBean cancelAllied(JSONObject jsonData)
    {
        JsonResultBean result = new JsonResultBean();
        try
        {
            // Create the web service object
            URL portAddress = new URL(this.url);
            com.hvlv.microservices.apiService.hvlvApiService.allied.TnTWebService service = new com.hvlv.microservices.apiService.hvlvApiService.allied.TnTWebServiceLocator();
            com.hvlv.microservices.apiService.hvlvApiService.allied.TTWS ttws = service.getTTWSPort(portAddress);
            int cancel = ttws.cancelDispatchJob (this.signatureKey, jsonData.getString("ref"), jsonData.getJSONObject("cnee").getString("postcde"));
            HashMap<String,String> data = new HashMap();
            result.setSuccess();
            result.setData(data);
            return result;

        }catch (Exception ex)
        {
            ex.printStackTrace();
            ArrayList<String> errorStr = new ArrayList();
            errorStr.add ("Unexpected Error");
            errorStr.add ("MyAllied:"+ex.getMessage());
            result.setError();
            result.setData(errorStr);
            return result;
        }
    }

}
