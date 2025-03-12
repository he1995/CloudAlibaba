package com.example.cloudalibaba;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
@EnableDiscoveryClient
public class CloudAlibabaApplication {

	@Value("${name:haha}")
	private String name;

	public static void main(String[] args) {
		SpringApplication.run(CloudAlibabaApplication.class, args);
	}

	@RequestMapping("/greet")
	public String getName() {
		return name;
	}

	@RestController
	class EchoController {
		@GetMapping(value = "/echo/{string}")
		public String echo(@PathVariable String string) {
			return string;
		}
	}

}
