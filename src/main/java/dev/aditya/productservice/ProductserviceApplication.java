package dev.aditya.productservice;

import dev.aditya.productservice.models.Category;
import dev.aditya.productservice.models.Product;
import dev.aditya.productservice.repositories.CategoryRepository;
import dev.aditya.productservice.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
public class ProductserviceApplication implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);

    }

    @Override
    @Transactional
    public void run(String... args) {

        Category category = new Category();
        category.setName("Sample Category");

        Category savedCategory = categoryRepository.save(category);

        Product product = new Product();
        product.setTitle("Sample Product");
        product.setDescription("Sample Description");
        product.setCategory(savedCategory);

        productRepository.save(product);

        Category category1 =  categoryRepository.findById(UUID.fromString("d30a72ca-144d-4e34-a04e-70984495cbc1")).orElseThrow();

        System.out.println("Category Name: " + category1.getName());

        System.out.println("lazy check before: " + Hibernate.isInitialized(category1.getProducts())); // false if LAZY, true if EAGER

        // Access the collection to trigger loading (if LAZY)
        System.out.println("Products in Category: " + category1.getProducts().size());

        System.out.println("lazy check after: " + Hibernate.isInitialized(category1.getProducts())); // false if LAZY, true if EAGER

        for (Product p : category1.getProducts()) {
            System.out.println("Product Title: " + p.getTitle());
        }
    }
}
