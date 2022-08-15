package com.example.demo.services;

import com.example.demo.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductDto getProduct(UUID id);

    void saveProduct(ProductDto productDto);

    List<ProductDto> getAll();

    void deleteProduct(UUID id);
}
