package dev.aditya.productservice.services;

import dev.aditya.productservice.thirdpartyclient.productsservice.fakestore.FakeStoreProductDto;
import dev.aditya.productservice.dtos.GenericProductDto;
import dev.aditya.productservice.thirdpartyclient.productsservice.fakestore.FakeStoreProductServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service("fakeStoreProduceService")
@AllArgsConstructor
public class FakeStoreProduceService implements ProductService{

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public GenericProductDto convertFakeProductToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        return product;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return  convertFakeProductToGenericProductDto(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public GenericProductDto getProductById(Long id) {

        return convertFakeProductToGenericProductDto(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {

        List<GenericProductDto> genericProductDtoList = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductServiceClient.getAllProducts()){

            genericProductDtoList.add(convertFakeProductToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtoList;
    }

    @Override
    public void deleteProductById(Long id) {

        fakeStoreProductServiceClient.deleteProductById(id);
    }

    @Override
    public void updateProductById(GenericProductDto product, long id) {

        fakeStoreProductServiceClient.updateProductById(product, id);
    }

}
