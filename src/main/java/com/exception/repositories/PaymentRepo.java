package com.exception.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exception.entities.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long>{

}
