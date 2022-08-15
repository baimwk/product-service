package com.example.demo.dto;
import com.example.demo.enums.ProductType;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductDto {
    UUID id;
    String name;
    ProductType productType;
}
