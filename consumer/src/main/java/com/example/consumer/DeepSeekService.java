package com.example.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "deepseek", url = "https://api.deepseek.com", configuration = FeignConfiguration.class)
public interface DeepSeekService {
    @PostMapping("/chat/completions")
    String completions(@RequestBody DeepRequest body);
}

