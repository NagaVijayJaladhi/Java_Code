package com.jaladhi.cms.repository;


import com.jaladhi.cms.entity.StudentEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
