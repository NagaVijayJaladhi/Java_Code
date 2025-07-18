package com.jaladhi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaladhi.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
}
