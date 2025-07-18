package com.jaladhi.cms.model;

import lombok.Data;
import lombok.Builder;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {

	private long id;
	
	private String firstName;
	
	private String surName;
	
	private String emailId;
	
	private String mobileNo;
	
}
