package com.hvlv.microservices.apiService.hvlvApiService.controller;

import com.alibaba.fastjson.JSONObject;
import com.hvlv.microservices.apiService.hvlvApiService.beans.DataBean;
import com.hvlv.microservices.apiService.hvlvApiService.beans.JsonResultBean;
import com.hvlv.microservices.apiService.hvlvApiService.service.TlaAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TlaAPIController {
    @Autowired
    Environment environment;
    @Autowired
    TlaAPIService tlaAPIService;

    @PostMapping("/tla/createLabels")
    public ResponseEntity<?> createLabels(@RequestParam("data") String data) {
        try {
            JSONObject obj = JSONObject.parseObject(data);
            // String noString = obj.getString("no");
            int base64 = 0;
            if (obj.containsKey("base64") && obj.get("base64")!= null) {
                base64 = obj.getIntValue("base64");
            }
            TlaAPIService tlaSevice = new TlaAPIService();
            Map<String, Object> params = new HashMap<>();
            params.put("data", data.toString());

            if (base64==1){
                String createLabel = tlaSevice.genLabelBase64(params);
                return ResponseEntity.ok(createLabel);
            }
            else{
                byte[] pdfContent = tlaSevice.genLabelPdf(params);
                ByteArrayResource resource;

                // 创建一个包含PDF内容的ByteArrayResource
                if (pdfContent!= null){
                    resource = new ByteArrayResource(pdfContent);
                }
                else{
                    resource = new ByteArrayResource(new byte[0]);
                }

                // 设置HTTP响应头
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=your-pdf-file.pdf");
                headers.setContentType(MediaType.APPLICATION_PDF);

                // 返回包含PDF内容的HTTP响应
                if (pdfContent!=null){
                    return ResponseEntity.ok()
                            .headers(headers)
                            .contentLength(pdfContent.length)
                            .body(resource);
                }
                else{
                    return ResponseEntity.ok()
                            .headers(headers)
                            .contentLength(0)
                            .body(resource);
                }

            }

        } catch (Exception e) {
            // 处理异常情况
            JsonResultBean response = new JsonResultBean();
            response.setSuccess();
            response.setMsg("Error creating label from shipment: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error creating label from shipment: " + e.getMessage());
        }
    }

}
