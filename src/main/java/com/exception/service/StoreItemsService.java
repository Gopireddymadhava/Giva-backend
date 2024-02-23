package com.exception.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.entities.CartItem;
import com.exception.entities.Store;
import com.exception.entities.StoreItems;
import com.exception.exceptions.StoreItemNotFoundException;
import com.exception.repositories.StoreItemsRepo;

@Service
public class StoreItemsService {
	
@Autowired
private StoreItemsRepo storeitemsrepo;


//Method used to get list of storeitems
public List<StoreItems> getAllstoreitems() {
	try {
	
	return storeitemsrepo.findAll();
	}
	catch(Exception e) {
		
        throw new StoreItemNotFoundException("Error while getting  storeitems");
	}
	
}



//Method used to get list of  storeitems based on cart Id
public List<StoreItems> getStoreItems(Long cartId) {
	try {
	
	return storeitemsrepo.findAll();
	}catch(Exception e) {
		
        throw new StoreItemNotFoundException("Error while  getting storeitems based on cartId");
	}
}


//Method used to get storeitems by id
public Optional<StoreItems> getStoreItemsById(Long id) {
	try {
	
	return storeitemsrepo.findById(id);
	}catch(Exception e) {
		
        throw new StoreItemNotFoundException("Error while searching  product");
	}
}


//Method created to save the store items
public StoreItems saveStoreItems(StoreItems storeItems,Long Id) {
	try {
	
	return storeitemsrepo.save(storeItems);
	}catch(Exception e) {
		
        throw new StoreItemNotFoundException("Error while saving  storeitems");
	}
}



//Method used to storeitems based on id
public StoreItems associateStoreWithItems(Long storeId, StoreItems storeItems) {
  
    if (storeItems.getId() == null) {
        Store store = new Store();
        store.setId(storeId);

        storeItems.setStore(store);

       
        return storeitemsrepo.save(storeItems);
    } else {
        
        Optional<StoreItems> existingStoreItems = storeitemsrepo.findById(storeItems.getId());

        if (existingStoreItems.isPresent()) {
            Store store = new Store();
            store.setId(storeId);

            storeItems.setStore(store);

           
            return storeitemsrepo.save(storeItems);
        } else {
           
            throw new StoreItemNotFoundException("StoreItems with ID " + storeItems.getId() + " not found");
        }
    }
}

//Method used to get list of storeitems by id
public List<StoreItems> getStoreItemsByStoreId(Long storeId) {
	try {
    return storeitemsrepo.findByStoreId(storeId);
	}catch(Exception e) {
		
        throw new StoreItemNotFoundException("Error while getting  storeitems based on id");
	}
}

//Method used to get list of storeitems based on pincode
public List<StoreItems> getStoreItemsByPincode(String pincode) {
	try {
    return storeitemsrepo.findByPincode(pincode);
	}catch(Exception e) {
		
        throw new StoreItemNotFoundException("Error while getting storeitems by pincode");
	}
}


}
