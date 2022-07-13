package com.example.demo.utils;

import com.example.demo.dto.ProductDto;
import com.example.demo.models.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductUtils {
    public ProductDto mapToProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductType(product.getProductType());
        productDto.setName(product.getName());
        return productDto;
    }

    public Product mapToProduct(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductType(productDto.getProductType());
        product.setName(productDto.getName());
        return product;
    }
}
