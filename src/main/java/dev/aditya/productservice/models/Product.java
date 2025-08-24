package dev.aditya.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {

    private String title;
    private String description;
    private String image;
    private Category category;
    private double price;

    public Product(String title, String description, String image, Category category, double price) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.category = category;
        this.price = price;
    }
}
