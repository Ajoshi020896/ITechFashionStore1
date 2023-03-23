package com.fashionstore.Model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	private Long orderId;

	private String orderType;

	private OrderStatus orderStatus;

	private Date orderDate;

	private Date delieveryDate;

	private String delieveryBy;

	private Customer customer;

	private List<Product> products;

	private Sprinter sprinter;

}
