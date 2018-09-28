package com.springcloud.feigncustomer;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
public class FeignCustomerApplication {

//	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	public static void main(String[] args) {
		SpringApplication.run(FeignCustomerApplication.class, args);
	}
}
