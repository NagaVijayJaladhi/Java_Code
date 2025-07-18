package com.jaladhi.cms.controller;

import java.util.Map;
import java.util.List;
import com.jaladhi.cms.model.StudentModel;
import org.springframework.http.ResponseEntity;
import com.jaladhi.cms.services.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.jaladhi.cms.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/getAllStudent")
	public List<StudentModel> getAllStudent() throws ResourceNotFoundException {
		return studentService.getAllStudent();
	}

	@GetMapping("/getStudentById/{id}")
	public ResponseEntity<StudentModel> getStudentById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
		return ResponseEntity.ok().body(studentService.getStudentById(employeeId));
	}

	@PostMapping("/saveStudent")
	public Map<String, Boolean> saveEmployee(@RequestBody StudentModel employee) throws ResourceNotFoundException {
		return studentService.saveStudent(employee);
	}
	
	@PutMapping("/updateStudent/{id}")
	public Map<String, Boolean> updateStudent(@PathVariable(value = "id") Long employeeId, @RequestBody StudentModel employee) throws ResourceNotFoundException {
		return studentService.updateStudent(employeeId, employee);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
		return studentService.deleteStudent(employeeId);
	}
}
