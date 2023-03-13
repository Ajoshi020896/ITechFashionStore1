package com.fashionstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.fashionstore")
public class ITechFashionStore1Application {

	public static void main(String[] args) {
		SpringApplication.run(ITechFashionStore1Application.class, args);
		System.out.println("I am ITechFashionStore Service 1 ");
		System.out.println("Bhaiya m kaam kr raha hu");

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
