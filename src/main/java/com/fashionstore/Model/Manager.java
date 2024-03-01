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
public class Manager {

	private long managerId;

	private String managerEmail;

	private String managerPassword;

	private String managerName;

	private String managerAddress;

	private long managerMobileNo;

	private Date updateDate;

	private Date createdDate;

	private List<Employee> employees;

}
