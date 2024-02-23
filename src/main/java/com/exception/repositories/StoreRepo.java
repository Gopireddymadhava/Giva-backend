package com.exception.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exception.entities.Store;
import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepo extends JpaRepository<Store, Long>{
Optional<Store> findById(Long id);
}
