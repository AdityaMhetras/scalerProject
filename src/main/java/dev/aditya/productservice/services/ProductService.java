package dev.aditya.productservice.services;

import dev.aditya.productservice.dtos.GenericProductDto;

public interface ProductService {

    GenericProductDto getProductById(Long id);
}
