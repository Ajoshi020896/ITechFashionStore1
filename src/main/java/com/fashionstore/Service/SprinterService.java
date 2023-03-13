package com.fashionstore.Service;

import org.springframework.stereotype.Service;

import com.fashionstore.DTO.OrderResponseWithSprinterDTO;
import com.fashionstore.Entities.Customer;
import com.fashionstore.Entities.Product;

@Service
public interface SprinterService {

	Product getProductById(Long productId);

	Customer getCustomerById(Long customerId);
	
	OrderResponseWithSprinterDTO getOrderDetails(Long orderId);

}
