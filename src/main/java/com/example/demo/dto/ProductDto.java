package com.example.demo.dto;
import com.example.demo.enums.ProductType;
import lombok.Data;

import java.util.UUID;

public class ProductDto {
    UUID id;
    String name;
    ProductType productType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
