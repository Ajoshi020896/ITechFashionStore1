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
public class Employee {
//8 fields including employeeId

	private long employeeId;
	private String employeeEmail;
	private String employeePassword;
	private String employeeName;
	private Date updatedDate;
	private Date createdDate;
	private long employeeMobileNo;
	private String employeeAddress;
	private Manager manager;

}
