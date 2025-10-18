package dev.aditya.productservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.aditya.productservice.dtos.GenericProductDto;
import dev.aditya.productservice.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// not initialize any other beans except the web layer beans like controllers, controller advices, filters, web configurations etc
//@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {

    private MockMvc mockMvc;
    private ProductService productService = Mockito.mock(ProductService.class); // Manual mock

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        ProductController productController = new ProductController(productService); // Manual instantiation
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

//    @Autowired
//    MockMvc mockMvc;

//    @MockBean
//    private ProductService productService;

    @Test
    void getAllProductsReturnEmptyListWhenNoProducts() throws Exception {

        when(productService.getAllProducts()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/api/v1/products"))
                .andExpect(status().is3xxRedirection())
                .andExpect(content().string("[]"));
    }

    @Test
    void returnListOfProductsWhenProductsExist() throws Exception {
        // This is a placeholder for an actual test method

        List<GenericProductDto> mockProducts = new ArrayList<>();
        mockProducts.add(new GenericProductDto());
        mockProducts.add(new GenericProductDto());
        mockProducts.add(new GenericProductDto());

        when(productService.getAllProducts()).thenReturn(mockProducts);

        mockMvc.perform(get("/api/v1/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(mockProducts)));
    }


}
