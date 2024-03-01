package com.fashionstore.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "ProductFeign", url = "http://localhost:8081/itechfashionstore/product")
public interface FeignServiceProductUtil {
	
	@GetMapping("/getallproducts")
	ResponseEntity<?> getAllProducts();

}
