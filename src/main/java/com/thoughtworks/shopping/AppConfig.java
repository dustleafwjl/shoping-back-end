package com.thoughtworks.shopping;


import com.thoughtworks.shopping.repository.ProductRepository;
import com.thoughtworks.shopping.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ProductService userService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }

}
