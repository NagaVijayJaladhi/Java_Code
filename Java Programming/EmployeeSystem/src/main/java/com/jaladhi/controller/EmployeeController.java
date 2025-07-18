package com.jaladhi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaladhi.entity.Employee;
import com.jaladhi.exception.ResourceNotFoundException;
import com.jaladhi.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepository;
	
	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empRepository.save(employee);
	}
	
	@GetMapping("/allEmployees")
	public List<Employee> getAllEmployee() {
		return empRepository.findAll();
	}
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) {
		Employee employee = null;
		try {
			employee = empRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found For This ID :: " + id));
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee employee) {
		Employee updatedEmployee = null;
		try {
			Employee updateEmployee = empRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found For This ID :: " + id));
			updateEmployee.setFirstName(employee.getFirstName());
			updateEmployee.setLastName(employee.getLastName());
			updateEmployee.setEmail(employee.getEmail());
			updatedEmployee = empRepository.save(updateEmployee);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long id) {
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		try {
			Employee employee = empRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found For This ID :: " + id));
			empRepository.delete(employee);
			response.put("deleted", Boolean.TRUE);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return response;
	}
}
