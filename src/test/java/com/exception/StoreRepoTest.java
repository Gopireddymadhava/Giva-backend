package com.exception;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exception.entities.Store;
import com.exception.repositories.StoreRepo;

@SpringBootTest(classes=GivaApplication.class)
public class StoreRepoTest {

	@Autowired
	private StoreRepo storerepo;
	
	@Test
	void isStoreexistsByid() {
		Store store=new Store();
		store.setId((long)2);
		store.setName("bengaluru");
		storerepo.save(store);
		Optional<Store> actualResult=storerepo.findById((long) 2);
		assertThat(actualResult).isSameAs(store);
	}

}
