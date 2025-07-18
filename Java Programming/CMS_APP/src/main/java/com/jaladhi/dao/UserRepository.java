package com.jaladhi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaladhi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
