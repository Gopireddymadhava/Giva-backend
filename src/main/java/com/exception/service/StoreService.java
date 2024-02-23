package com.exception.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.dto.StoreDto;
import com.exception.entities.Store;
import com.exception.exceptions.StoreNotFoundException;
import com.exception.repositories.StoreRepo;

@Service
public class StoreService {
	@Autowired
	private StoreRepo storeRepository;

	//Method used for getting List of stores
    public List<Store> getAllStores() {
    	try {
        return storeRepository.findAll();
    	}catch(Exception e) {
			
	        throw new StoreNotFoundException("Error while getting  stores");
		}
    }

   //Method used to get Store by id
    public Optional<Store> getStoreById(Long id) {
    	try {
        return storeRepository.findById(id);
    	}catch(Exception e) {
		
	        throw new StoreNotFoundException("Error while getting store by id");
		}
    }

   //Method used to save the store
    public Store saveStore(Store store) {
    	try {
        return storeRepository.save(store);
    	}catch(Exception e) {
		
	        throw new StoreNotFoundException("Error while saving store ");
		}
    }
    
  

  //Method used to delete the store based on id
    public void deleteStore(Long id) {
    	try {
        storeRepository.deleteById(id);
    	}catch(Exception e) {
			
	        throw new RuntimeException("Error while deleting  store", e);
		}
    }


	
	
}
