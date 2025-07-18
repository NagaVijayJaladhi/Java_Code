package com.jaladhi.cms.services;

import java.util.Map;
import java.util.List;
import com.jaladhi.cms.model.StudentModel;
import org.springframework.stereotype.Service;
import com.jaladhi.cms.exception.ResourceNotFoundException;


@Service
public interface StudentService {

	public List<StudentModel> getAllStudent() throws ResourceNotFoundException;
	public StudentModel getStudentById(Long id) throws ResourceNotFoundException;
	public Map<String, Boolean> deleteStudent(Long id) throws ResourceNotFoundException ;
	public Map<String, Boolean> saveStudent(StudentModel student) throws ResourceNotFoundException;
	public Map<String, Boolean> updateStudent(Long id, StudentModel student) throws ResourceNotFoundException;
	
}
