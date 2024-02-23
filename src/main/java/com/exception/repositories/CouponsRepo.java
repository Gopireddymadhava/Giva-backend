package com.exception.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exception.dto.CouponsDto;
import com.exception.entities.Coupons;

@Repository
public interface CouponsRepo extends JpaRepository<Coupons, Long>{
	Optional<Coupons> findByCode(String code);

}
