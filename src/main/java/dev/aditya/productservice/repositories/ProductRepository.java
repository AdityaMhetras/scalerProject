package dev.aditya.productservice.repositories;

import dev.aditya.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findAllByDescriptionEquals(String description);

    List<Product> findAllByDescriptionAndPrice_Currency(String title, String currency);
}
