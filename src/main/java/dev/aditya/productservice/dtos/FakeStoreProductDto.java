package dev.aditya.productservice.dtos;

public class FakeStoreProductDto {

    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCategory() {
        return this.category;
    }

    public String getImage() {
        return this.image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
