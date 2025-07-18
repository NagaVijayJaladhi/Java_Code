package com.jaladhi.cms.entity;

import lombok.Data;
import lombok.Builder;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMPLOYEE")
@Component
public class EmployeeEntity {

	@Id
	@Column(name = "EMPLOYEE_ID")
	private long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "SUR_NAME")
	private String surName;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "MOBILE_NO")
	private String mobileNo;	
	
}
