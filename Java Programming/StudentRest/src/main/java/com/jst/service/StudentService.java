package com.jst.service;

import java.util.List;

import com.jst.entity.StudentEntity;

public interface StudentService {

	public void addStudent(StudentEntity student);
	public List<StudentEntity> getAllStudent();
	public StudentEntity getByStudentId(long id);
}
