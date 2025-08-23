package dev.aditya.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {

    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
}
