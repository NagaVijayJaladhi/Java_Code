package com.jaladhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaladhi.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String>{

}
