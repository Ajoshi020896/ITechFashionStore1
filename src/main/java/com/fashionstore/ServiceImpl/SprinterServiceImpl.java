package com.fashionstore.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fashionstore.DTO.CustomerOrderResponseDTO;
import com.fashionstore.DTO.OrderResponseDTO;
import com.fashionstore.Entities.Customer;
import com.fashionstore.Entities.Order;
import com.fashionstore.Entities.Product;
import com.fashionstore.Exception.EntityNotFoundException;
import com.fashionstore.FeignClient.FeignServiceProductUtil;
import com.fashionstore.Repository.CustomerRepository;
import com.fashionstore.Repository.OrderRepository;
import com.fashionstore.Repository.ProductRepository;
import com.fashionstore.Repository.SprinterRepository;
import com.fashionstore.Service.SprinterService;

@Service
public class SprinterServiceImpl implements SprinterService {
	@Autowired
	private SprinterRepository sprinterRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private FeignServiceProductUtil feignServiceProductUtil;

	@Override
	public Product getProductById(Long productId) {

		Optional<Product> optionalProduct = productRepository.findById(productId);

		if (optionalProduct.isEmpty()) {

			throw new EntityNotFoundException("601", "No Product found with " + productId + " Id");
		}

		else {

			Product product = optionalProduct.get();

			return product;
		}
	}

	@Override
	public Customer getCustomerById(Long customerId) {

		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

		if (optionalCustomer.isEmpty()) {

			throw new EntityNotFoundException("601", "Customer With " + customerId + " not found");
		}

		else {

			Customer customerDb = optionalCustomer.get();

			return customerDb;
		}
	}

	@Override
	public OrderResponseDTO getOrderDetailsForSprinter(Long orderId) {

		Optional<Order> optionalOrder = orderRepository.findById(orderId);

		if (optionalOrder.isEmpty()) {

			throw new EntityNotFoundException("601", "Order with id " + orderId + " is not present");
		}
		Order dbOrder = optionalOrder.get();
		OrderResponseDTO response = new OrderResponseDTO();
		response.setOrderId(dbOrder.getOrderId());
		response.setOrderDate(dbOrder.getOrderDate());
		response.setOrderType(dbOrder.getOrderType());
		response.setDeliveryDate(dbOrder.getDelieveryDate());
		Customer dbCustomer = dbOrder.getCustomer();
		CustomerOrderResponseDTO customerOrderResponseDTO = new CustomerOrderResponseDTO();
		customerOrderResponseDTO.setCustomerId(dbCustomer.getCustomerId());
		customerOrderResponseDTO.setCustomerName(dbCustomer.getCustomerName());
		customerOrderResponseDTO.setCustomerMobileNo(dbCustomer.getCustomerMobileNo());
		customerOrderResponseDTO.setCustomerAddress(dbCustomer.getCustomerAddress());
		response.setCustomerOrderResponseDTO(customerOrderResponseDTO);

		return response;
	}

	@Override
	public ResponseEntity<?> getAllProducts() {

		System.out.println("Inside serviceImpl of sprinter");

		return feignServiceProductUtil.getAllProducts();

	}
}
