package dev.aditya.productservice.controllers;

import dev.aditya.productservice.dtos.GenericProductDto;
import dev.aditya.productservice.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockitoBean
    private ProductService productService;

    @Test
    void returnNullWhenProductDoesntExist() {

        when(productService.getProductById(any(Long.class))).thenReturn(null);

        GenericProductDto genericProductDto = productController.getProductById(145454554L);

        assertNull(genericProductDto);
        // This is a placeholder for an actual test method
    }

    @Test
    void shouldReturnTitleABCWithProductId1() {

        GenericProductDto mockProduct = new GenericProductDto();
        mockProduct.setId(1L);
        mockProduct.setTitle("ABC");

        when(productService.getProductById(1L)).thenReturn(mockProduct);

        GenericProductDto genericProductDto = productController.getProductById(1L);

        assertNotNull(genericProductDto);
        assertEquals("ABC", genericProductDto.getTitle());
    }

    @Test
    @DisplayName("Addition should be correct")
    void additionShouldBeCorrect() {
        assert 2 + 2 == 4;
        assert -1 + 1 == 0;
        assert 0 + 0 == 0;
        assert 100 + 200 == 300;
    }

    @Test
    @DisplayName("1 + 1 equals 2")
    void onePlusOneEqualsTwo() {
        System.out.println("it is true");
        assertEquals(11, 1 + 1, "1 + 1 is not 11");
        assertThrows(NullPointerException.class, () -> {;
            String str = null;
            str.length();
        }, "Expected NullPointerException to be thrown");
    }


}
