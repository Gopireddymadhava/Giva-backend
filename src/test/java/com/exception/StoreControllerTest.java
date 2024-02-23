package com.exception;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.error.ShouldHaveSameSizeAs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockRequestDispatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.exception.controller.StoreController;
import com.exception.dto.StoreDto;
import com.exception.entities.Store;
import com.exception.entities.StoreItems;
import com.exception.repositories.StoreRepo;
import com.exception.service.StoreItemsService;
import com.exception.service.StoreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import jakarta.validation.constraints.Size;
@AutoConfigureMockMvc
@SpringBootTest(classes = GivaApplication.class)
public class StoreControllerTest {
	
	
	
	@Autowired
    private MockMvc mockMvc;

    @Mock
    private StoreService storeService;
    
    @Mock
    private StoreItemsService storeItemsService;

    @InjectMocks
    private StoreController storeController;

    @Test
    public void testGetAllStores() throws Exception {
        // Mock data
        Store store1 = new Store(2L, "bengaluru");
        Store store2 = new Store(3L, "Chandigarh");
        Store store3 = new Store(4L, "Chandigarh");
        Store store4 = new Store(5L, "Chandigarh");
        Store store5 = new Store(6L, "Chandigarh");
        Store store6 = new Store(7L, "Chandigarh");
        Store store7 = new Store(8L, "Chandigarh");
        Store store8 = new Store(9L, "Chandigarh");
        Store store9 = new Store(10L, "Chandigarh");
        Store store10 = new Store(11L, "Chandigarh");
        Store store11 = new Store(12L, "Chandigarh");
        Store store12 = new Store(13L, "Chandigarh");
        Store store13 = new Store(14L, "Chandigarh");
        Store store14 = new Store(15L, "Chandigarh");
        Store store15 = new Store(16L, "Chandigarh");
        Store store16 = new Store(17L, "Chandigarh");
        Store store17 = new Store(18L, "Chandigarh");
        Store store18 = new Store(19L, "Chandigarh");
        Store store19 = new Store(20L, "Siliguri");
       Store store20=new Store(21L,"Rajamandry");
        
        List<Store> mockStores = Arrays.asList(store1, store2,store3,store4,store5,store6,store7,store8,store9,store10,store11,store12,store13,store14,store15,store16,store17,store18,store19,store20);

        // Mock the service method
        when(storeService.getAllStores()).thenReturn(mockStores);

        // Perform the request and verify the response
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/getstores")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(mockStores.size()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(store1.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value(store2.getName()));
    }
  
    
//    @Test
//    void saveStore() throws Exception {
//        // Mocking the behavior of the service
//        Store store = new Store(21L,"Rajamundry");
//        when(storeService.saveStore(store)).thenReturn(store);
//
//        // Performing the request using MockMvc
//        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/savestore")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(store)))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(store.getName()));
//    }

//    @Test
//    void saveStoreItems() throws Exception {
//        // Mocking the behavior of the service
//        StoreItems storeItems = new StoreItems("Giva Nexus Shantikethan","nexus shatikethan mall","7","bengalure",(long) 1);
//        when(storeItemsService.saveStoreItems(storeItems, 2L)).thenReturn(storeItems);
//
//        // Performing the request using MockMvc
//        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/savestoreitems/2")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(storeItems)))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.distance").value(storeItems.getDistance()));
//    }


}
