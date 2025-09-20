package dev.aditya.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

}
