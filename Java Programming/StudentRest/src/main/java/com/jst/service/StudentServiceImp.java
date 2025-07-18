package com.jst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jst.entity.StudentEntity;
import com.jst.repository.StudentRepository;

public class StudentServiceImp implements StudentService {

	@Autowired
	public StudentRepository studentRepo;
	
	@Override
	public void addStudent(StudentEntity student) {
		studentRepo.save(student);
	}

	@Override
	public List<StudentEntity> getAllStudent() {
		return studentRepo.findAll();
	}

	@Override
	public StudentEntity getByStudentId(long id) {
		return studentRepo.findById(id);
	}

}
