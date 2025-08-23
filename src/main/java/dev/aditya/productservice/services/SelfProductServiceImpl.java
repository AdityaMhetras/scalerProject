package dev.aditya.productservice.services;

import dev.aditya.productservice.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements  ProductService {
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }
}
