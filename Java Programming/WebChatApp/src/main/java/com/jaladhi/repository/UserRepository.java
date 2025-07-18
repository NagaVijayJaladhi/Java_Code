package com.jaladhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jaladhi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	@Transactional
	Long deleteByUsername(String username);

}
