package com.fashionstore.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fashionstore.Entities.Product;

@FeignClient(value = "feignDemo", url = "http://localhost:8080/product")
public interface FeignServiceUtil {

	@GetMapping("/getallproducts")
	List<Product> getAllProducts();

}
