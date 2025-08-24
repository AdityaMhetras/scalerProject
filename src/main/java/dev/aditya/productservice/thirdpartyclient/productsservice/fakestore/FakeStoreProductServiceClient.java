package dev.aditya.productservice.thirdpartyclient.productsservice.fakestore;

import dev.aditya.productservice.dtos.GenericProductDto;
import dev.aditya.productservice.exceptions.NotFoundException;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/***
 * Wrapper over FakeStore API
 */

@Service
public class FakeStoreProductServiceClient {

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Value("${fakestore.api.url}")
    private String fakeStoreApiUrl;

    @Value("${fakestore.api.paths.products}")
    private String fakeStoreApiProductsPath;

    private RestTemplateBuilder restTemplateBuilder;

    private String getProductRequestURL;
    private String productRequestBaseURL;

    @PostConstruct
    public void init() {
        getProductRequestURL = fakeStoreApiUrl + fakeStoreApiProductsPath + "/{id}";
        productRequestBaseURL = fakeStoreApiUrl + fakeStoreApiProductsPath;
    }


    public FakeStoreProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(productRequestBaseURL, product, FakeStoreProductDto.class);

        return response.getBody();
    }

    public FakeStoreProductDto getProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(getProductRequestURL, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        if (fakeStoreProductDto == null) {
//            throw new ArrayIndexOutOfBoundsException();
            throw new NotFoundException("Product not found with id:" + id);
        }
        return fakeStoreProductDto;
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestBaseURL, FakeStoreProductDto[].class);

        assert response.getBody() != null;
        return Arrays.stream(response.getBody()).toList();
    }

    public void deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(getProductRequestURL, id);
    }

    public void updateProductById(GenericProductDto product, long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.put(getProductRequestURL, product, id);
    }

}
