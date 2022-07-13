package com.example.demo;

import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.demo.enums.ProductType.*;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductRepository repository) {
        return (args) -> {
            repository.save(new Product("Fruit Salad by 'Organic shop'", VEGAN));
            repository.save(new Product("Chicken Shawarma", HALAL));
            repository.save(new Product("Pork Kebab", NORMAL));
        };
    }

}
