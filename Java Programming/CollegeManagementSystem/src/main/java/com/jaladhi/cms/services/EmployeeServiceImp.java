package com.jaladhi.cms.services;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.jaladhi.cms.model.EmployeeModel;
import com.jaladhi.cms.utilies.CmsConstants;
import org.springframework.stereotype.Service;
import com.jaladhi.cms.repository.EmployeeRepository;
import com.jaladhi.cms.entity.EmployeeEntity;
import com.jaladhi.cms.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private EmployeeEntity employeeEntity;
		
	private Map<String, Boolean> response = new HashMap<>();
	
	@Override
	public List<EmployeeModel> getAllEmployee() throws ResourceNotFoundException {
		List<EmployeeModel> listEmployee = new ArrayList<>();
		List<EmployeeEntity> listEmployeeEntity = employeeRepo.findAll();
		listEmployeeEntity.stream().forEach(listEmp -> listEmployee.add(EmployeeModel.builder().id(listEmp.getId()).firstName(listEmp.getFirstName()).surName(listEmp.getSurName()).emailId(listEmp.getEmailId()).mobileNo(listEmp.getMobileNo()).build()));
		return listEmployee;
	}

	@Override
	public EmployeeModel getEmployeeById(Long id) throws ResourceNotFoundException {
		employeeEntity = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(CmsConstants.EMPLOYEE_NOT_FOUND + id));
		return EmployeeModel.builder().id(id).firstName(employeeEntity.getFirstName()).surName(employeeEntity.getSurName()).emailId(employeeEntity.getEmailId()).mobileNo(employeeEntity.getMobileNo()).build();
	}

	@Override
	public Map<String, Boolean> saveEmployee(EmployeeModel employee) throws ResourceNotFoundException {
		employeeEntity = EmployeeEntity.builder().id(employee.getId()).firstName(employee.getFirstName()).surName(employee.getSurName()).emailId(employee.getEmailId()).mobileNo(employee.getMobileNo()).build();
		employeeRepo.save(employeeEntity);
		response.put(CmsConstants.EMPLOYEE_SAVE, Boolean.TRUE);
		return response;
	}

	@Override
	public Map<String, Boolean> updateEmployee(Long id, EmployeeModel employee) throws ResourceNotFoundException {
		employeeEntity = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(CmsConstants.EMPLOYEE_NOT_FOUND + id));
		employeeEntity = EmployeeEntity.builder().firstName(employee.getFirstName()).surName(employee.getSurName()).emailId(employee.getEmailId()).mobileNo(employee.getMobileNo()).build();
		employeeRepo.save(employeeEntity);
		response.put(CmsConstants.EMPLOYEE_UPDATE, Boolean.TRUE);
		return response;
	}

	@Override
	public Map<String, Boolean> deleteEmployee(Long id) throws ResourceNotFoundException {
		employeeRepo.delete(employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(CmsConstants.EMPLOYEE_NOT_FOUND + id)));
		response.put(CmsConstants.EMPLOYEE_DELETE, Boolean.TRUE);
		return response;
	}

}
