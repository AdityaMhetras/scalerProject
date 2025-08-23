package dev.aditya.productservice.services;

import dev.aditya.productservice.dtos.FakeStoreProductDto;
import dev.aditya.productservice.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreProduceService")
public class FakeStoreProduceService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestURL = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestURL = "https://fakestoreapi.com/products";

    public FakeStoreProduceService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(createProductRequestURL, product, GenericProductDto.class);

        return response.getBody();
    }

    @Override
    public GenericProductDto getProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(getProductRequestURL, FakeStoreProductDto.class, id);
        FakeStoreProductDto  fakeStoreProductDto = response.getBody();

        GenericProductDto product = new GenericProductDto();
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
//        response.getStatusCode()
        return product;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity response = restTemplate.getForEntity(createProductRequestURL, List.class);
        return (List<GenericProductDto>) response.getBody();
    }

    @Override
    public void deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(getProductRequestURL, id);
    }

    @Override
    public void updateProductById(GenericProductDto product, long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.put(getProductRequestURL, product, id);
    }
}
