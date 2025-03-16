package com.example.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private EchoService echoService;

    @Autowired
    private DeepSeekService deepSeekService;

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    public TestController(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
        this.discoveryClient = discoveryClient;
        restClient = restClientBuilder.build();
    }

    @GetMapping(value = "/echo-rest/{str}")
    public String rest(@PathVariable String str) {
        ServiceInstance serviceInstance = discoveryClient.getInstances("CloudAlibaba").get(0);
        String serviceAResponse = restClient.get()
                .uri(serviceInstance.getUri() + "/echo/" + str)
                .retrieve()
                .body(String.class);
        return serviceAResponse;
    }

    @GetMapping("/echo-feign/{str}")
    public String feign(@PathVariable String str) {
        return echoService.echo(str);
    }

    @PostMapping("/chat")
    public String chat(@RequestBody DeepRequest body) {
        return deepSeekService.completions(body);
    }
}