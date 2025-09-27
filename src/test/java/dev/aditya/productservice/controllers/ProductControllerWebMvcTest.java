package dev.aditya.productservice.controllers;

import dev.aditya.productservice.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// not initialize any other beans except the web layer beans like controllers, controller advices, filters, web configurations etc
//@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {

    private MockMvc mockMvc;
    private ProductService productService = Mockito.mock(ProductService.class); // Manual mock

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
}
