package com.jst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jst.entity.StudentEntity;
import com.jst.service.StudentService;

@RestController
@RequestMapping(name = "/student")
public class StudentController {

	@Autowired
	public StudentService studentService;
	
	@PostMapping
	public void createStudent(@RequestBody StudentEntity student) {
		studentService.addStudent(student);
	}
	
	@GetMapping("/getAllStudnet")
	public List<StudentEntity> getAllStudent() {
		return studentService.getAllStudent();
	}
	
	@GetMapping("/getByStudnetId/{id}")
	public StudentEntity getAllStudent(@PathVariable long id) {
		return studentService.getByStudentId(id);
	}
}
