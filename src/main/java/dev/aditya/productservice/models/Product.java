package dev.aditya.productservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category")
    private Category category;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Price price;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

}
