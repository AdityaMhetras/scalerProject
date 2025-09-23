package dev.aditya.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseModel {

    @ManyToMany
    @JoinTable(
            name = "product_orders",
            joinColumns = @jakarta.persistence.JoinColumn(name = "order_id"),
            inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
