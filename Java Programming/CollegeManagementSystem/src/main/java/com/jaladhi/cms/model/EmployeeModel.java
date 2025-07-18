package com.jaladhi.cms.model;

import lombok.Data;
import lombok.Builder;
import lombok.ToString;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;


@Data
@Builder
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {

	private long id;
	
	private String firstName;
	
	private String surName;
	
	private String emailId;
	
	private String mobileNo;
	
}
