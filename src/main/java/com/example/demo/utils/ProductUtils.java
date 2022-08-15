package com.example.demo.utils;

import com.example.demo.dto.ProductDto;
import com.example.demo.models.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductUtils {
    ProductDto mapToProductDto(Product product);

    Product mapToProduct(ProductDto productDto);
}
