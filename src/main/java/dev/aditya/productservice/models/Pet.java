package dev.aditya.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@PrimaryKeyJoinColumn(name = "petId")
@Data
public class Pet extends Animal {
    private String name  ;
}
