package com.soft.consumer.api;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author chenrongqi
 */

@RestController
public class ConsumerController {
    private final String SERVICE_URL = "http://jzbdfr.natappfree.cc/api";

    @Resource
    private RestTemplate restTemplate;

    private WebClient webClient = WebClient.builder()
            .baseUrl(SERVICE_URL)
            .build();

    @GetMapping("/httpClientTest")
    public String httpClientTest() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(SERVICE_URL + "/httpClientTest");
        CloseableHttpResponse response = null;
        String result = null;
        try {
            response = httpClient.execute(httpGet);
            // 判断状态码
            if(response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(result);
            }
        } finally {
            if(response != null) {
                response.close();
            }
            httpClient.close();
        }
        return "请求成功" + result;
    }

    @GetMapping("/restTemplateTest")
    public String restTemplateTest() {
        System.out.println(restTemplate.getForObject(SERVICE_URL + "/restTemplateTest", String.class));
        return restTemplate.getForObject(SERVICE_URL + "/restTemplateTest", String.class);
    }

    @GetMapping("/webClientTest")
    public String webClientTest() {
        Mono<String> mono = webClient.get().uri("/webClientTest").retrieve().bodyToMono(String.class);
        mono.subscribe(System.out::println);
        return "请求成功";
    }
}
