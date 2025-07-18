package com.jaladhi.cms.repository;


import com.jaladhi.cms.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
