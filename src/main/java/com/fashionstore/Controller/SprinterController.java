package com.fashionstore.Controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashionstore.DTO.OrderResponseDTO;
import com.fashionstore.Entities.Customer;
import com.fashionstore.Entities.Product;
import com.fashionstore.Exception.ControllerException;
import com.fashionstore.Service.SprinterService;

@RestController
@RequestMapping("itechfashionstoreservice1/sprinter")
public class SprinterController {

	@Autowired
	private SprinterService sprinterService;

	@GetMapping("/hello")
	public String getHello() {

		return "Hello Bhai";

	}

	// get product by id
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") Long productId) {
		System.out.println("working re");

		try {

			Product productResponse = sprinterService.getProductById(productId);
			return new ResponseEntity<Product>(productResponse, HttpStatus.OK);

		} catch (EntityNotFoundException e) {

			return new ResponseEntity<String>("No Product found with Id " + productId, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "Something wrong with the Controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}

	// getting customer by id
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") Long customerId) {
		try {
			Customer responseCustomer = sprinterService.getCustomerById(customerId);
			return new ResponseEntity<Customer>(responseCustomer, HttpStatus.FOUND);
		}

		catch (EntityNotFoundException e) {

			ControllerException ce = new ControllerException("601", e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		}
	}

	// getting order details by id
	@GetMapping("/getOrderDetailsForSprinter/{orderId}")
	public ResponseEntity<?> getOrderDetailsForSprinter(@PathVariable Long orderId) {
		System.out.println("working fine reee");
		try {
			OrderResponseDTO response = sprinterService.getOrderDetailsForSprinter(orderId);
			return new ResponseEntity<OrderResponseDTO>(response, HttpStatus.FOUND);
		}

		catch (EntityNotFoundException e) {

			ControllerException ce = new ControllerException("601", e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		}

	}

	// feign client testing
	@GetMapping("/getallproductsbysprinter")
	public ResponseEntity<?> getAllProducts() {

		try {
             System.out.println("Inside sprinter controller");
			ResponseEntity<?> productResponse = sprinterService.getAllProducts();
			return new ResponseEntity<>(productResponse.getBody(), HttpStatus.OK);

		} catch (EntityNotFoundException e) {

			return new ResponseEntity<String>("No Product found ", HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {
			e.printStackTrace();
			ControllerException ce = new ControllerException("601", "Something wrong with the Controller");
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);
		}

	}

}
