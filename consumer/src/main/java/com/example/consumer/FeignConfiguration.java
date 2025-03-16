package com.example.consumer;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            public void apply(RequestTemplate requestTemplate) {
                requestTemplate.header("content-type", "application/json");
                requestTemplate.header("accept", "application/text");
                requestTemplate.header("Authorization", "Bearer sk-845c6f143f224272a385994d86cb9a33");
            }
        };
    }
}
