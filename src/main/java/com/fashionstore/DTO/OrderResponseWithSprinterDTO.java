package com.fashionstore.DTO;

import java.util.Date;

import com.fashionstore.DTO.CustomerOrderResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseWithSprinterDTO {
	
	private Long orderId;
	private String orderType;
	private Date orderDate;
	private Date delieveryDate;
	private CustomerOrderResponseDTO customerOrderResponseDto;
	private SprinterOrderResponseDTO sprinterOrderResponseDTO;

}
