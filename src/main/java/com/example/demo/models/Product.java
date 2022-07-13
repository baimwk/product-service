package com.example.demo.models;

import com.example.demo.enums.ProductType;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;
    private String name;
    ProductType productType;

    public Product() {
    }

    public Product(String name, ProductType productType) {
        this.name = name;
        this.productType = productType;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && productType == product.productType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productType);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productType=" + productType +
                '}';
    }
}
