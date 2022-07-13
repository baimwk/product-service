package com.example.demo.services;

import com.example.demo.dto.ProductDto;
import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductUtils productUtils;

    public ProductDto getProduct(UUID id) {
        return productUtils.mapToProductDto(
                productRepository.findById(id)
                        .orElse(new Product()));

    }

    public void saveProduct(ProductDto product) {
        Product product1 = productUtils.mapToProduct(product);
        productRepository.save(product1);
    }

    public List<ProductDto> getAll() {
        return productRepository.findAll().stream()
                .map(productUtils::mapToProductDto).collect(Collectors.toList());
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
