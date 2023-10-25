package com.hvlv.microservices.springcloudapigatewayservice.hvlvspringcloudapigatewayservice.config;

//import com.hvlv.microservices.springcloudapigatewayservice.hvlvspringcloudapigatewayservice.service.ApiService;
import com.hvlv.microservices.springcloudapigatewayservice.hvlvspringcloudapigatewayservice.entity.Api;
import com.hvlv.microservices.springcloudapigatewayservice.hvlvspringcloudapigatewayservice.mapper.ApiMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
        import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
        import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Gateway Auth
 *
 * @author Gero Zeng
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ApiMapper apiMapper;

    private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String uri = exchange.getRequest().getURI().getPath();
        ServerHttpRequest request = exchange.getRequest();
        if (request.getMethod() != HttpMethod.POST) {
            return setUnauthorizedResponse(exchange, "This req is only support :" + request.getMethod());
        }
        return DataBufferUtils.join(exchange.getRequest().getBody()).flatMap(dataBuffer -> {
            byte[] bytes = new byte[dataBuffer.readableByteCount()];
            dataBuffer.read(bytes);
            try {
                String bodyString = new String(bytes, "utf-8");
                Map<String,String> postDataMap = new HashMap<String,String>();
                String pattern = "\"api_id\"\r\n\r\n(.*)\r\n";
                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(bodyString);
                if(m.find( ))
                {
                    postDataMap.put("api_id",m.group(1));
                } else {
                    return setUnauthorizedResponse(exchange, "without api id");
                }
                String params []= new String []{"method","data","sign"};
                for (String paramKey:params) {
                    pattern = "\""+paramKey+"\"\r\n\r\n(.*)\r\n";
                    r = Pattern.compile(pattern);
                    m = r.matcher(bodyString);
                    if(m.find( ))
                    {
                        postDataMap.put(paramKey,m.group(1));
                    } else {
                        return setUnauthorizedResponse(exchange, "without "+paramKey);
                    }
                }
                String apiId = postDataMap.get("api_id");
                String sign = postDataMap.get("sign");
                //ApiService apiService = new ApiService();
                //Api api = apiService.select(postDataMap.get("api_id"));
//                RedisDao redisDao = new RedisDao();
                String apiKey = stringRedisTemplate.opsForValue().get("hvlv:userKey"+apiId);
                if(apiKey==null)
                {
                    Api api = apiMapper.select(postDataMap.get("api_id"));
                    if(api!=null)
                    {
                        stringRedisTemplate.opsForValue().set("hvlv:userKey"+apiId,api.getKey());
                    }else
                    {
                        return setUnauthorizedResponse(exchange, "Unauthrized User");
                    }
                    apiKey = api.getKey();
                }
                if(!this.validate(apiKey,sign,postDataMap))
                {
                    return setUnauthorizedResponse(exchange, "Wrong Api Sign");
                }


                exchange.getAttributes().put("POST_BODY", bodyString);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            DataBufferUtils.release(dataBuffer);
            Flux<DataBuffer> cachedFlux = Flux.defer(() -> {
                DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
                return Mono.just(buffer);
            });
            ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(exchange.getRequest()) {
                @Override
                public Flux<DataBuffer> getBody() {
                    return cachedFlux;
                }
            };
// String reqBody = (String)exchange.getAttributes().get("POST_BODY");
// log.info("===> reqBody:{}", reqBody);
            ServerWebExchange mutableExchange = exchange.mutate().request(mutatedRequest).build();
            return chain.filter(mutableExchange);
        });
    }

    private boolean validate(String apiKey, String sign, Map<String,String> postDataMap)
    {
        boolean result = false;
        Set<String> set= postDataMap.keySet();
        String postDataMapKey []= postDataMap.keySet().toArray(new String[set.size()]);;
        Arrays.sort(postDataMapKey);
        String s = apiKey;
        for (String k:postDataMapKey) {
            if(k=="sign") continue;
            s+=k+postDataMap.get(k);
        }
        s += apiKey;
        //log.info("MD5待加密字符串：\n"+s);
        String md5 = "  ";
        try {
            md5 = DigestUtils.md5DigestAsHex(s.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //log.info("MD5加密结果：\n"+md5);
        md5 = md5.toUpperCase();
        sign = sign.toUpperCase();
        if (md5.equals(sign))
        {
            result = true;
        }
        return result;
    }

        private Mono<Void> setUnauthorizedResponse(ServerWebExchange exchange, String msg)
    {
        ServerHttpResponse originalResponse = exchange.getResponse();
        originalResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
        originalResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        byte[] response = null;
        try
        {
            String errorString = "{\"error\": \"401\",\"error\": \""+msg+"\"}";
            response = errorString.getBytes("utf8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        DataBuffer buffer = originalResponse.bufferFactory().wrap(response);
        return originalResponse.writeWith(Flux.just(buffer));
    }
    @Override
    public int getOrder() {
        return -200;
    }
}
