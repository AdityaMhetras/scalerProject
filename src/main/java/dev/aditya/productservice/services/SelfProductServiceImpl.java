package dev.aditya.productservice.services;

import dev.aditya.productservice.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements  ProductService {
    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return List.of();
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public void updateProductById(GenericProductDto product, long id) {

    }
}
