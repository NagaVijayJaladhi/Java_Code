package com.jaladhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaladhi.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String> {

}
