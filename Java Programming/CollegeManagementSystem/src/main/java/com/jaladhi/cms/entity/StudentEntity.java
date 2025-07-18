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
@Table(name = "STUDENT")
@Component
public class StudentEntity {

	@Id
	@Column(name = "STUDENT_ID")
	private long studentId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "SUR_NAME")
	private String surName;
	
	@Column(name = "BRANCH")
	private String branch;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "MOBILE_NO")
	private String mobileNo;	
	
}
