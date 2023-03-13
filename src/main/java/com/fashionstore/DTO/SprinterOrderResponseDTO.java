package com.fashionstore.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SprinterOrderResponseDTO {

	private Long sprinterId;
	private String sprinterName;
	private Long sprinterMobileNo;
	private String sprinterConvenceType;

}
