package com.fashionstore.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private long productId;
	private String productName;
	private int productSize;
	private Long productPrice;
	private String productCategory;

	// @ManyToMany(targetEntity = Customer.class)
	// private List<Customer> customers;

}
