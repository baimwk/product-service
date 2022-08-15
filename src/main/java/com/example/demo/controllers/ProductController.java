package com.example.demo.controllers;

import com.example.demo.dto.ProductDto;
import com.example.demo.services.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
    @Autowired
    ProductServiceImpl productServiceImpl;

    @GetMapping("/get-all")
    public List<ProductDto> getAll() {
        log.info("Get all products");
        return productServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable UUID id) {
        log.info("Get product by id = {}", id);
        try {
            ProductDto product = productServiceImpl.getProduct(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody ProductDto product) {
        log.info("Add new product = {}", product);
        productServiceImpl.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody ProductDto product, @PathVariable UUID id) {
        log.info("Update product. Set {} by id {}", product, id);
        productServiceImpl.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID id) {
        log.info("Delete product by id = {}", id);
        try {
            productServiceImpl.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
