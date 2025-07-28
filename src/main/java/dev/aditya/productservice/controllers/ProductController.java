package dev.aditya.productservice.controllers;

import dev.aditya.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/products")
public class ProductController {

    @GetMapping
    public void getAllProducts() {
    }

    // localhost:8080/products/123
    @GetMapping("{id}")
    public String  getProductById(@PathVariable("id") long id) {
        return "here is product id : " + id;
    }

    @DeleteMapping("{id}")
    public void deleteProductById(String id) {

    }

    @PostMapping
    public String createProduct() {
        return "Create product successfully, id: " + UUID.randomUUID();
    }

    @PutMapping("{id}")
    public void updateProductById() {

    }
}
