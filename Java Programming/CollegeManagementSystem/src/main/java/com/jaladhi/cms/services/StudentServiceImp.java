package com.jaladhi.cms.services;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import com.jaladhi.cms.model.StudentModel;
import com.jaladhi.cms.entity.StudentEntity;
import com.jaladhi.cms.utilies.CmsConstants;
import org.springframework.stereotype.Service;
import com.jaladhi.cms.repository.StudentRepository;
import com.jaladhi.cms.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private StudentEntity studentEntity;
		
	private Map<String, Boolean> response = new HashMap<>();
	
	@Override
	public List<StudentModel> getAllStudent() throws ResourceNotFoundException {
		List<StudentModel> listStudent = new ArrayList<>();
		List<StudentEntity> listStudentEntity = studentRepo.findAll();
		listStudentEntity.stream().forEach(listEmp -> listStudent.add(StudentModel.builder().id(listEmp.getStudentId()).firstName(listEmp.getFirstName()).surName(listEmp.getSurName()).emailId(listEmp.getEmailId()).mobileNo(listEmp.getMobileNo()).build()));
		return listStudent;
	}

	@Override
	public StudentModel getStudentById(Long id) throws ResourceNotFoundException {
		studentEntity = studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(CmsConstants.STUDENT_NOT_FOUND + id));
		return StudentModel.builder().id(id).firstName(studentEntity.getFirstName()).surName(studentEntity.getSurName()).emailId(studentEntity.getEmailId()).mobileNo(studentEntity.getMobileNo()).build();
	}

	@Override
	public Map<String, Boolean> saveStudent(StudentModel employee) throws ResourceNotFoundException {
		studentEntity = StudentEntity.builder().studentId(employee.getId()).firstName(employee.getFirstName()).surName(employee.getSurName()).emailId(employee.getEmailId()).mobileNo(employee.getMobileNo()).build();
		studentRepo.save(studentEntity);
		response.put(CmsConstants.STUDENT_SAVE, Boolean.TRUE);
		return response;
	}

	@Override
	public Map<String, Boolean> updateStudent(Long id, StudentModel employee) throws ResourceNotFoundException {
		studentEntity = studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(CmsConstants.STUDENT_NOT_FOUND + id));
		studentRepo.save(studentEntity);
		response.put(CmsConstants.STUDENT_UPDATE, Boolean.TRUE);
		return response;
	}

	@Override
	public Map<String, Boolean> deleteStudent(Long id) throws ResourceNotFoundException {
		studentRepo.delete(studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(CmsConstants.STUDENT_NOT_FOUND + id)));
		response.put(CmsConstants.STUDENT_DELETE, Boolean.TRUE);
		return response;
	}

}
