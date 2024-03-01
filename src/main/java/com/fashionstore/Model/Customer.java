package com.fashionstore.Model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	private long customerId;

	private String customerName;

	private String customerEmail;

	private String customerPassword;

	private String customerAddress;

	private long customerMobileNo;

	private Date createdDate;

	// @ManyToMany(mappedBy = "customers")
	// private List<Product> products;

}
