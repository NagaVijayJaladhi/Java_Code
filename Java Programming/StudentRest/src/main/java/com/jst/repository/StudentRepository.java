package com.jst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jst.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
	
	public StudentEntity findById(long id);
}
