package dev.aditya.productservice.controllers;

import dev.aditya.productservice.dtos.GenericProductDto;
import dev.aditya.productservice.models.Product;
import dev.aditya.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/products")
public class ProductController {
//field injection
//    @Autowired
    private ProductService productService;

//    constructor injection
    public ProductController(@Qualifier("fakeStoreProduceService") ProductService productService) {
        this.productService = productService;
    }

//    setter injection
/*    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }*/

    @GetMapping
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    // localhost:8080/products/123
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public void updateProductById(@RequestBody GenericProductDto product, @PathVariable("id") long id) {
        productService.updateProductById(product, id);
    }
}
