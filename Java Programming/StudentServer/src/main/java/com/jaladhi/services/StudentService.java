package com.jaladhi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jaladhi.model.Student;

@Service
public interface StudentService {

	public boolean saveStudent(Student student);

	public List<Student> getStudents();

	public boolean deleteStudent(Student student);

	public List<Student> getStudentByID(Student student);

	public boolean updateStudent(Student student);

}
