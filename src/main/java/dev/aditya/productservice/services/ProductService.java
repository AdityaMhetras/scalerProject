package dev.aditya.productservice.services;

import dev.aditya.productservice.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id);

    List<GenericProductDto> getAllProducts();

    void deleteProductById(Long id);

    void updateProductById(GenericProductDto product, long id);
}
