package dev.aditya.productservice;

import dev.aditya.productservice.models.Category;
import dev.aditya.productservice.models.Price;
import dev.aditya.productservice.models.Product;
import dev.aditya.productservice.repositories.CategoryRepository;
import dev.aditya.productservice.repositories.PriceRepository;
import dev.aditya.productservice.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class ProductserviceApplication implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);

    }

    @Override
    @Transactional
    public void run(String... args) {

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

/*        UUID productId = UUID.fromString("65bdf0bc-3846-4138-a751-5e84710f6ebb");
        productRepository.findById(productId)
                .ifPresentOrElse(
                        productRepository::delete,
                        () -> System.out.println("Product not found with id: ")
                );*/
        /// /////////////////////
//        productRepository.delete(productRepository.getById(UUID.fromString("65bdf0bc-3846-4138-a751-5e84710f6ebb")));

        /*System.out.println("Category saved with ID: " + savedCategory.getUuid());
        Category category1 =  categoryRepository.findById(savedCategory.getUuid()).orElseThrow();
        System.out.println("category1: " + category1);
        System.out.println("Category Name: " + category1.getName());
        System.out.println("lazy check before: " + Hibernate.isInitialized(category1.getProducts())); // false if LAZY, true if EAGER

        // Access the collection to trigger loading (if LAZY)
        System.out.println("Products in Category: " + category1.getProducts().size());

        System.out.println("lazy check after: " + Hibernate.isInitialized(category1.getProducts())); // false if LAZY, true if EAGER

        for (Product p : category1.getProducts()) {
            System.out.println("Product Title: " + p.getTitle());
        }*/
    }
}
