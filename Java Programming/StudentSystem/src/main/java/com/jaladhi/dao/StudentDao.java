package com.jaladhi.dao;

import java.util.List;

import com.jaladhi.entity.Student;

public interface StudentDao {

	public boolean saveStudent(Student student);  
    public List<Student> getStudents();  
    public boolean deleteStudent(Student student);  
    public List<Student> getStudentByID(Student student);  
    public boolean updateStudent(Student student);  
    
}
