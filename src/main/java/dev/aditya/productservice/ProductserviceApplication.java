package dev.aditya.productservice;

import dev.aditya.productservice.models.Category;
import dev.aditya.productservice.models.Price;
import dev.aditya.productservice.models.Product;
import dev.aditya.productservice.repositories.CategoryRepository;
import dev.aditya.productservice.repositories.PriceRepository;
import dev.aditya.productservice.repositories.ProductRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
public class ProductserviceApplication implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;
    private final EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);

    }

    @Override
    @Transactional
    public void run(String... args) throws InterruptedException {

        Category category = new Category();
        category.setName("Sample Category");
//        Category savedCategory = categoryRepository.save(category);

        Price price = new Price("Rupee", 10);
//        Price savedPrice =  priceRepository.save(price);

        Product product = new Product();
        product.setTitle("Sample Product");
        product.setDescription("Sample Description");
        product.setCategory(category);
        product.setPrice(price);
        productRepository.save(product);

        List<Product> prWithDesc = productRepository.findAllByDescriptionEquals("Sample Description");

        List<Product> prWithDescAndCurr = productRepository.findAllByDescriptionAndPrice_Currency("Sample Description", "Rupee");

        List<Product> prWithTitle = productRepository.findAllByTitle("Sample Product");

        List<Product> prWithTitleAndCurr = productRepository.findAllByTitleAndPrice_Currency("Sample Product", "Rupee");
        System.out.println("Products with Description 'Sample Description': " + prWithDesc.size());
/*        UUID productId = UUID.fromString("65bdf0bc-3846-4138-a751-5e84710f6ebb");
        productRepository.findById(productId)
                .ifPresentOrElse(
                        productRepository::delete,
                        () -> System.out.println("Product not found with id: ")
                );*/
        /// /////////////////////
//        productRepository.delete(productRepository.getById(UUID.fromString("65bdf0bc-3846-4138-a751-5e84710f6ebb")));

//        Thread.sleep(1000);
        /*entityManager.clear();
        System.out.println("1. searching Category with ID: 93ec9e87-5cbe-4332-93b9-f4623366456e");
        Category category1 =  categoryRepository.findById(UUID.fromString("93ec9e87-5cbe-4332-93b9-f4623366456e")).orElseThrow();
//        System.out.println("category1: " + category1);
        System.out.println("2. Category Name: " + category1.getName());

//        Thread.sleep(1000);
        System.out.println("is category1.getProducts() initialzed: " + Hibernate.isInitialized(category1.getProducts())); // false if LAZY, true if EAGER

        // Access the collection to trigger loading (if LAZY)
        System.out.println("Products in Category: " + category1.getProducts().size());

        System.out.println("is category1.getProducts() initialzed2: " + Hibernate.isInitialized(category1.getProducts())); // true if initialized

        for (Product p : category1.getProducts()) {
            System.out.println("Product Title: " + p.getTitle());
        }*/

        //N+1 Problem demonstration
        entityManager.clear();
        System.out.println("\nDemonstrating N+1 Problem:");
        // Fetch all categories (1 query)
        List<Category> categories = categoryRepository.findAll();

        for (Category cat : categories) {
            // For each category, accessing products triggers a separate query (N queries)
            System.out.println("Products count: " + cat.getProducts().size());
        }

    }
}
