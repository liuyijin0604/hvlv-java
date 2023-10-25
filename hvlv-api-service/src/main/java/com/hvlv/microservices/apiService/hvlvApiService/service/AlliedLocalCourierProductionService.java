package com.hvlv.microservices.apiService.hvlvApiService.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.apiService.hvlvApiService.allied.*;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;
import com.hvlv.microservices.apiService.hvlvApiService.beans.ScanBean;
import com.hvlv.microservices.apiService.hvlvApiService.client.LabelClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;

@Service
public class AlliedLocalCourierProductionService extends HvlvService implements AlliedInterface{
    private List<String> pregMatchs;
    private Matcher m;
    private String signatureKey;
    private String accountCode;
    private String url;

    @Autowired
    LabelClient labelClient;

    @Autowired
    RedisService redisService;

    public AlliedLocalCourierProductionService() {
        pregMatchs = new ArrayList<String>();
        signatureKey = "8b6dcb97c3d81c241a69c9bd44cbfb58";
        accountCode = "TOPLOG";
        url = "http://neptune.alliedexpress.com.au:8080/ttws-ejb/TTWS";
    }

    public JsonResultBean createAlliedShipment(JSONObject jsonData)
    {
        JsonResultBean labelResult = labelClient.generateRefByPrefix("{\"prefix\":\""+jsonData.getString("prefix")+"\",\"orgId\":4429}");
        if(labelResult.isSuccess())
        {
            String jsonString = JSON.toJSONString(labelResult.getData());
            JSONObject data = JSON.parseObject(jsonString);
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
            com.hvlv.microservices.apiService.hvlvApiService.alliedTest.TnTWebService service = new com.hvlv.microservices.apiService.hvlvApiService.alliedTest.TnTWebServiceLocator();
            com.hvlv.microservices.apiService.hvlvApiService.alliedTest.TTWS ttws = service.getTTWSPort(portAddress);
            JSONObject shipper = jsonData.getJSONObject("shipper");
            // Get the account to use
            com.hvlv.microservices.apiService.hvlvApiService.alliedTest.Account account = ttws.getLocalCourierAccountDefaults(this.signatureKey,
                    this.accountCode,
                    shipper.getString("state"),
                    "AET");
            // Construct the job stop objects

            JSONObject consignee = jsonData.getJSONObject("consignee");

            com.hvlv.microservices.apiService.hvlvApiService.alliedTest.GeographicAddress pickupAddress = new com.hvlv.microservices.apiService.hvlvApiService.alliedTest.GeographicAddress();
            pickupAddress.setAddress1(shipper.getString("address"));
            pickupAddress.setSuburb(shipper.getString("suburb"));
            pickupAddress.setState(shipper.getString("state"));
            pickupAddress.setPostCode(shipper.getString("postcode"));

            com.hvlv.microservices.apiService.hvlvApiService.alliedTest.GeographicAddress deliveryAddress = new com.hvlv.microservices.apiService.hvlvApiService.alliedTest.GeographicAddress();
            deliveryAddress.setAddress1(consignee.getString("address"));
            deliveryAddress.setSuburb(consignee.getString("suburb"));
            deliveryAddress.setState(consignee.getString("state"));
            deliveryAddress.setPostCode(consignee.getString("postcode"));


            com.hvlv.microservices.apiService.hvlvApiService.alliedTest.JobStop pickupStop = new com.hvlv.microservices.apiService.hvlvApiService.alliedTest.JobStop();
            pickupStop.setCompanyName(shipper.getString("company"));
            pickupStop.setContact(shipper.getString("name"));
            pickupStop.setGeographicAddress(pickupAddress);
            pickupStop.setPhoneNumber(shipper.getString("phone"));
            pickupStop.setStopType("P");
            pickupStop.setStopNumber(1);
            com.hvlv.microservices.apiService.hvlvApiService.alliedTest.JobStop deliveryStop = new com.hvlv.microservices.apiService.hvlvApiService.alliedTest.JobStop();
            deliveryStop.setCompanyName(consignee.getString("company"));
            deliveryStop.setContact(consignee.getString("name"));
            deliveryStop.setGeographicAddress(deliveryAddress);
            deliveryStop.setPhoneNumber(consignee.getString("phone"));
            deliveryStop.setStopType("D");
            deliveryStop.setStopNumber(2);
            com.hvlv.microservices.apiService.hvlvApiService.alliedTest.JobStop[] jobStops = new com.hvlv.microservices.apiService.hvlvApiService.alliedTest.JobStop[] { pickupStop, deliveryStop };
// Construct the Item objects
            JSONArray items = jsonData.getJSONArray("packages");
            com.hvlv.microservices.apiService.hvlvApiService.alliedTest.Item[] jobItems = new com.hvlv.microservices.apiService.hvlvApiService.alliedTest.Item[items.size()];
            for (int i=0;i<jobItems.length;i++)
            {
                com.hvlv.microservices.apiService.hvlvApiService.alliedTest.Item jobItem1 = new com.hvlv.microservices.apiService.hvlvApiService.alliedTest.Item();
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
            for (com.hvlv.microservices.apiService.hvlvApiService.alliedTest.Item item : jobItems)
            {
                totalItems += item.getItemCount();
                totalWeight += item.getWeight() * item.getItemCount();
                totalVolume += item.getVolume() * item.getItemCount();
            }
            // Construct the Job object
            com.hvlv.microservices.apiService.hvlvApiService.alliedTest.Job job = new com.hvlv.microservices.apiService.hvlvApiService.alliedTest.Job();
            job.setAccount(account);
            job.setInstructions(jsonData.getString("instruction")); // Optional
            job.setItemCount(totalItems);
            job.setWeight(totalWeight);
            job.setVolume(totalVolume);
            job.setItems(jobItems);
            job.setJobStops(jobStops);
            job.setServiceLevel("N");
            job.setReferenceNumbers(referenceNumbers); // Optional
            job.setBookedBy(shipper.getString("name"));
            job.setReadyDate(readyDate);
            job.setDocketNumber(jsonData.getString("ref"));
            job = ttws.quoteLocalCourierJob(this.signatureKey, job);
            // Check that there were no errors
            if (job.getJobErrors() == null || job.getJobErrors(0) == null)
            {
                job = ttws.bookLocalCourierJob(this.signatureKey, job);
                int jobId = job.getJobNumber();
                int[] jobIDs = new int[1];
                jobIDs[0] = jobId;
                //Job[] jobs = ttws.dispatchPendingJobs(this.signatureKey, jobIDs);
                result.setSuccess();
                result.setData(job);
                return result;

            }
            else
            {
                ArrayList<String> errorStr = new ArrayList();
                // Job not validated
                for (com.hvlv.microservices.apiService.hvlvApiService.alliedTest.JobError je : job.getJobErrors())
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
            com.hvlv.microservices.apiService.hvlvApiService.allied.TnTWebService service = new com.hvlv.microservices.apiService.hvlvApiService.allied.TnTWebServiceLocator();
            com.hvlv.microservices.apiService.hvlvApiService.allied.TTWS ttws = service.getTTWSPort(portAddress);
            JSONObject shipper = jsonData.getJSONObject("shipper");
            // Get the account to use
            com.hvlv.microservices.apiService.hvlvApiService.allied.Account account = ttws.getLocalCourierAccountDefaults(this.signatureKey,
                    this.accountCode,
                    shipper.getString("state"),
                    "AET");
            // Construct the job stop objects

            JSONObject consignee = jsonData.getJSONObject("consignee");

            com.hvlv.microservices.apiService.hvlvApiService.allied.GeographicAddress pickupAddress = new com.hvlv.microservices.apiService.hvlvApiService.allied.GeographicAddress();
            pickupAddress.setAddress1(shipper.getString("address"));
            pickupAddress.setSuburb(shipper.getString("suburb"));
            pickupAddress.setState(shipper.getString("state"));
            pickupAddress.setPostCode(shipper.getString("postcode"));

            com.hvlv.microservices.apiService.hvlvApiService.allied.GeographicAddress deliveryAddress = new com.hvlv.microservices.apiService.hvlvApiService.allied.GeographicAddress();
            deliveryAddress.setAddress1(consignee.getString("address"));
            deliveryAddress.setSuburb(consignee.getString("suburb"));
            deliveryAddress.setState(consignee.getString("state"));
            deliveryAddress.setPostCode(consignee.getString("postcode"));


            com.hvlv.microservices.apiService.hvlvApiService.allied.JobStop pickupStop = new com.hvlv.microservices.apiService.hvlvApiService.allied.JobStop();
            pickupStop.setCompanyName(shipper.getString("company"));
            pickupStop.setContact(shipper.getString("name"));
            pickupStop.setGeographicAddress(pickupAddress);
            pickupStop.setPhoneNumber(shipper.getString("phone"));
            pickupStop.setStopType("P");
            pickupStop.setStopNumber(1);
            com.hvlv.microservices.apiService.hvlvApiService.allied.JobStop deliveryStop = new com.hvlv.microservices.apiService.hvlvApiService.allied.JobStop();
            deliveryStop.setCompanyName(consignee.getString("company"));
            deliveryStop.setContact(consignee.getString("name"));
            deliveryStop.setGeographicAddress(deliveryAddress);
            deliveryStop.setPhoneNumber(consignee.getString("phone"));
            deliveryStop.setStopType("D");
            deliveryStop.setStopNumber(2);
            com.hvlv.microservices.apiService.hvlvApiService.allied.JobStop[] jobStops = new com.hvlv.microservices.apiService.hvlvApiService.allied.JobStop[] { pickupStop, deliveryStop };
// Construct the Item objects
            JSONArray items = jsonData.getJSONArray("packages");
            com.hvlv.microservices.apiService.hvlvApiService.allied.Item[] jobItems = new com.hvlv.microservices.apiService.hvlvApiService.allied.Item[items.size()];
            for (int i=0;i<jobItems.length;i++)
            {
                com.hvlv.microservices.apiService.hvlvApiService.allied.Item jobItem1 = new com.hvlv.microservices.apiService.hvlvApiService.allied.Item();
                jobItem1.setDangerous(false);
                jobItem1.setLength(Double.parseDouble(items.getJSONObject(i).getString("length"))); // in centi meter
                jobItem1.setWidth( Double.parseDouble(items.getJSONObject(i).getString("width"))); // in centi meter
                jobItem1.setHeight(Double.parseDouble(items.getJSONObject(i).getString("height"))); // in centi meter
                jobItem1.setVolume(Double.parseDouble(items.getJSONObject(i).getString("cbm"))); // in centi meter
                jobItem1.setWeight(Double.parseDouble(items.getJSONObject(i).getString("weight"))); // in centi meter
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
            for (com.hvlv.microservices.apiService.hvlvApiService.allied.Item item : jobItems)
            {
                totalItems += item.getItemCount();
                totalWeight += item.getWeight() * item.getItemCount();
                totalVolume += item.getVolume() * item.getItemCount();
            }
            // Construct the Job object
            com.hvlv.microservices.apiService.hvlvApiService.allied.JobExt jobExt = new com.hvlv.microservices.apiService.hvlvApiService.allied.JobExt();
            com.hvlv.microservices.apiService.hvlvApiService.allied.Job job = new com.hvlv.microservices.apiService.hvlvApiService.allied.Job();
            job.setAccount(account);
            job.setInstructions(jsonData.getString("instruction")); // Optional
            job.setItemCount(totalItems);
            job.setWeight(totalWeight);
            job.setVolume(totalVolume);
            job.setItems(jobItems);
            job.setJobStops(jobStops);
            job.setServiceLevel("N");
            job.setBookedBy(shipper.getString("name"));
            job.setReadyDate(readyDate);
            jobExt.setJob(job);
            jobExt = ttws.validateBookingExt(this.signatureKey, jobExt);
            Double totalCharge = jobExt.getJob().getPrice().getNetPrice() +
                    jobExt.getOnForwardChargeDelivery() + jobExt.getOnForwardChargePickup() + jobExt.getFreightOversizedHomeDel();
            // Check that there were no errors
            if (jobExt.getJob().getJobErrors() == null || jobExt.getJob().getJobErrors(0) == null)
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
            else {
                ArrayList<String> errorStr = new ArrayList();
                // Job not validated
                for (com.hvlv.microservices.apiService.hvlvApiService.allied.JobError je : jobExt.getJob().getJobErrors()) {
                    errorStr.add(je.getErrorMsg());
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
            com.hvlv.microservices.apiService.hvlvApiService.allied.TnTWebService service = new com.hvlv.microservices.apiService.hvlvApiService.allied.TnTWebServiceLocator();
            com.hvlv.microservices.apiService.hvlvApiService.allied.TTWS ttws = service.getTTWSPort(portAddress);
            JSONObject consignee = jsonData.getJSONObject("consignee");
            // Get the account to use
            com.hvlv.microservices.apiService.hvlvApiService.allied.Job job = ttws.getLocalCourierJobDetails(this.signatureKey,jsonData.getInteger("jobNumber"),"","AET",consignee.getString("postcode"));
            // extract all job stops
            com.hvlv.microservices.apiService.hvlvApiService.allied.Scanning[] scan = job.getScannings();
            ScanBean[]  scanBeans  = new ScanBean[scan.length];

            if (scan!=null&&scan.length>0)
            {
                for (int i=0;i<scan.length;i++)
                {
                    scanBeans[i] = new ScanBean(scan[i].getBatchID(),scan[i].getConsignmentNote(),scan[i].getConsignmentPart(),scan[i].getDriverNum(),scan[i].getLocation(),scan[i].getScanDate(),scan[i].getUserID());
                }
                HashMap<String, ScanBean[]> re = new HashMap();
                re.put("tracking_data",scanBeans);
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
            int cancel = ttws.cancelDispatchJob (this.signatureKey, jsonData.getString("ref"), jsonData.getJSONObject("consignee").getString("postcode"));
            HashMap<String,String> data = new HashMap();
            if(cancel==0) {
                data.put("cancelStatus", cancel + "");
                result.setSuccess();
                result.setData(data);
            }else
            {
                data.put("cancelStatus", cancel + "");
                result.setError();
                result.setData(data);
            }
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
