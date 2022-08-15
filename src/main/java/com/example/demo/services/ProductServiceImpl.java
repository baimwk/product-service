package com.example.demo.services;

import com.example.demo.dto.ProductDto;
import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.utils.ProductUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductUtils productUtils;

    @Transactional(readOnly=true)
    @Override
    public ProductDto getProduct(UUID id) {
        log.debug("Get product by id = {}", id);
        return productUtils.mapToProductDto(
                productRepository.findById(id)
                        .orElse(new Product()));

    }

    @Override
    public void saveProduct(ProductDto productDto) {
        log.debug("Save product {}", productDto);
        Product product = productUtils.mapToProduct(productDto);
        productRepository.save(product);
    }

    @Transactional(readOnly=true)
    @Override
    public List<ProductDto> getAll() {
        log.debug("Get all products");
        return productRepository.findAll().stream()
                .map(productUtils::mapToProductDto).collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(UUID id) {
        log.debug("Delete product by id = {}", id);
        productRepository.deleteById(id);
    }
}
