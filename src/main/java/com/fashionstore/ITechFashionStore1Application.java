package com.fashionstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ITechFashionStore1Application {

	public static void main(String[] args) {
		SpringApplication.run(ITechFashionStore1Application.class, args);
		System.out.println("I am ITechFashionStore Service 1 ");
		System.out.println("Bhaiya m kaam kr raha hu 8082 port p");

	}
    
//	@Bean
//	public RestTemplate getRestTemplate() {
//		return new RestTemplate();
//	}
	
//	@Bean
//	public ModelMapper getModelMapper() {
//		return new ModelMapper();
//	}

}
