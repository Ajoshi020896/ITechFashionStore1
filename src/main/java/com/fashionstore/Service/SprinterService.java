package com.fashionstore.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fashionstore.DTO.OrderResponseDTO;
import com.fashionstore.Entities.Customer;
import com.fashionstore.Entities.Product;



@Service
public interface SprinterService {

	Product getProductById(Long productId);

	Customer getCustomerById(Long customerId);
	
	OrderResponseDTO getOrderDetailsForSprinter(Long orderId);

	ResponseEntity<?> getAllProducts();

}
