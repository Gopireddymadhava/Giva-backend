package com.exception.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.dto.StoreDto;
import com.exception.entities.Store;
import com.exception.entities.StoreItems;
import com.exception.service.StoreItemsService;
import com.exception.service.StoreService;

import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="*")
@RestController
public class StoreController {
	@Autowired
	private StoreService storeservice;
	
	@Autowired
	private StoreItemsService storeitemsservice;
	
	
	// Get all stores
	@GetMapping("/getstores")
	public ResponseEntity<List<Store>> getAllStores() {
	    // Retrieve and return all stores
	    return ResponseEntity.ok(storeservice.getAllStores());
	}

	// Get store by ID
	@GetMapping("/getstore/{id}")
	public ResponseEntity<Optional<Store>> getStoreById(@PathVariable Long id) {
	    // Retrieve and return store by ID
	    Optional<Store> store = storeservice.getStoreById(id);
	    return ResponseEntity.ok(store);
	}

	// Save a new store
	@PostMapping("/savestore")
	public ResponseEntity<Store> saveStore(@RequestBody Store store) {
	    // Save and return the created store
	    return ResponseEntity.ok(storeservice.saveStore(store));
	}

	// Delete a store by ID
	@DeleteMapping("/deletestore/{id}")
	public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
	    // Delete the store by ID
	    storeservice.deleteStore(id);
	    return ResponseEntity.noContent().build();
	}

	// Get all store items
	@GetMapping("/getallstoreitems")
	public ResponseEntity<List<StoreItems>> getAllStoreItems() {
	    // Retrieve and return all store items
	    return ResponseEntity.ok(storeitemsservice.getAllstoreitems());
	}

	// Get store items by ID
	@GetMapping("/getstoreitem/{id}")
	public ResponseEntity<Optional<StoreItems>> getStoreItemsById(@PathVariable Long id) {
	    // Retrieve and return store items by ID
	    Optional<StoreItems> storeItems = storeitemsservice.getStoreItemsById(id);
	    return ResponseEntity.ok(storeItems);
	}

	// Get store items by store ID
	@GetMapping("/by-store/{storeId}")
	public ResponseEntity<List<StoreItems>> getStoreItemsByStoreId(@PathVariable Long storeId) {
	    // Retrieve and return store items by store ID
	    List<StoreItems> storeItems = storeitemsservice.getStoreItemsByStoreId(storeId);
	    return ResponseEntity.ok(storeItems);
	}

	// Save store items for a specific store
	@PostMapping("/savestoreitems/{Id}")
	public ResponseEntity<StoreItems> saveStoreItems(@RequestBody StoreItems storeItems, @PathVariable Long Id) {
	    // Save and return the created store items for the specified store ID
	    return ResponseEntity.ok(storeitemsservice.saveStoreItems(storeItems, Id));
	}

	// Associate store with items
	@PostMapping("/getstoreitems/{storeId}")
	public ResponseEntity<StoreItems> associateStoreWithItems(
	        @PathVariable Long storeId,
	        @RequestBody StoreItems storeItems
	) {
	    // Associate store with items and return the result
	    return ResponseEntity.ok(storeitemsservice.associateStoreWithItems(storeId, storeItems));
	}

	// Get store items by pincode
	@GetMapping("/bypincode/{pincode}")
	public List<StoreItems> getStoreItemsByPincode(@PathVariable String pincode) {
	    // Retrieve and return store items by pincode
	    return storeitemsservice.getStoreItemsByPincode(pincode);
	}

	    }

