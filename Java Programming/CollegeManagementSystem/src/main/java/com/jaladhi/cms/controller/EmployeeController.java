package com.jaladhi.cms.controller;

import java.util.Map;
import java.util.List;
import com.jaladhi.cms.model.EmployeeModel;
import org.springframework.http.ResponseEntity;
import com.jaladhi.cms.services.EmployeeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.jaladhi.cms.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getAllEmployee")
	public List<EmployeeModel> getAllEmployee() throws ResourceNotFoundException {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
		return ResponseEntity.ok().body(employeeService.getEmployeeById(employeeId));
	}

	@PostMapping("/saveEmployee")
	public Map<String, Boolean> saveEmployee(@RequestBody EmployeeModel employee) throws ResourceNotFoundException {
		return employeeService.saveEmployee(employee);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public Map<String, Boolean> updateEmployee(@PathVariable(value = "id") Long employeeId, @RequestBody EmployeeModel employee) throws ResourceNotFoundException {
		return employeeService.updateEmployee(employeeId, employee);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
		return employeeService.deleteEmployee(employeeId);
	}
}
