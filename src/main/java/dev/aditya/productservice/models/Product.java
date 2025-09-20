package dev.aditya.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel {

    private String title;
    private String description;
    private String image;
    /*
    * 1 product : 1 Category
    * many product : 1 category
    * */
    @ManyToOne
    private Category category;
    private double price;

}
