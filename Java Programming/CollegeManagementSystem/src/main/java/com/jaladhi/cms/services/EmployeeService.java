package com.jaladhi.cms.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jaladhi.cms.exception.ResourceNotFoundException;
import com.jaladhi.cms.model.EmployeeModel;

@Service
public interface EmployeeService {

	public List<EmployeeModel> getAllEmployee() throws ResourceNotFoundException;
	public EmployeeModel getEmployeeById(Long id) throws ResourceNotFoundException;
	public Map<String, Boolean> deleteEmployee(Long id) throws ResourceNotFoundException ;
	public Map<String, Boolean> saveEmployee(EmployeeModel employee) throws ResourceNotFoundException;
	public Map<String, Boolean> updateEmployee(Long id, EmployeeModel employee) throws ResourceNotFoundException;
	
}
