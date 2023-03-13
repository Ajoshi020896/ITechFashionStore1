package com.fashionstore.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fashionstore.Controller.ManagerController;
import com.fashionstore.DTO.OrderResponseDTO;
import com.fashionstore.DTO.OrderResponseWithSprinterDTO;
import com.fashionstore.DTO.SprinterOrderResponseDTO;
import com.fashionstore.Entities.Customer;
import com.fashionstore.Entities.Product;
import com.fashionstore.Entities.Sprinter;
import com.fashionstore.Exception.EntityNotFoundException;
import com.fashionstore.Repository.CustomerRepository;
import com.fashionstore.Repository.OrderRepository;
import com.fashionstore.Repository.ProductRepository;
import com.fashionstore.Repository.SprinterRepository;
import com.fashionstore.Service.ManagerService;
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
	private ManagerController managerController;

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
	public OrderResponseWithSprinterDTO getOrderDetails(Long orderId) {
		
		OrderResponseWithSprinterDTO finalResponse=new OrderResponseWithSprinterDTO();
		
		/* By putting the jar of core project we are like inheriting the project so don't need to call RestTemplate, we are in same service 
		OrderResponseDTO orderResponseDto=restTemplate.getForObject("http://localhost:8080/manager/getOrderDetailById/"+orderId, OrderResponseDTO.class,orderId);*/
		
		// Direct Autowiring and calling the response from the core project
		OrderResponseDTO orderResponseDto=(OrderResponseDTO)managerController.getOrderDetailById(orderId).getBody();
		finalResponse.setOrderId(orderResponseDto.getOrderId());
		finalResponse.setOrderDate(orderResponseDto.getOrderDate());
		finalResponse.setOrderType(orderResponseDto.getOrderType());
		finalResponse.setDelieveryDate(orderResponseDto.getDelieveryDate());
		finalResponse.setCustomerOrderResponseDto(orderResponseDto.getCustomerOrderResponseDto());
		
		Sprinter dbSprinter=orderRepository.findByOrderId(orderId).getSprinter();
		
		SprinterOrderResponseDTO sprinterOrderResponseDTO=new SprinterOrderResponseDTO();
		sprinterOrderResponseDTO.setSprinterId(dbSprinter.getSprinterId());
		sprinterOrderResponseDTO.setSprinterName(dbSprinter.getSprinterName());
		sprinterOrderResponseDTO.setSprinterMobileNo(dbSprinter.getSprinterMobileNo());
		sprinterOrderResponseDTO.setSprinterConvenceType(dbSprinter.getSprinterConvenceType());
		
		finalResponse.setSprinterOrderResponseDTO(sprinterOrderResponseDTO);
		
		return finalResponse;
		
		
	}

	
	
	
}
