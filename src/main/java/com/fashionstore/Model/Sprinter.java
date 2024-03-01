package com.fashionstore.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Sprinter {
	
	private Long sprinterId;
	
	private String sprinterName;
	
	private Long sprinterMobileNo;
	
	private String sprinterAddress;
	
	private String sprinterConvenceType;
	
	private Manager manager;
}
