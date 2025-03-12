package com.example.consumer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class TestController {



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
}