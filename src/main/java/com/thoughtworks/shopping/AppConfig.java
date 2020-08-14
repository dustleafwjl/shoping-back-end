package com.thoughtworks.shopping;


import com.thoughtworks.shopping.repository.OrderRepository;
import com.thoughtworks.shopping.repository.ProductRepository;
import com.thoughtworks.shopping.service.OrderService;
import com.thoughtworks.shopping.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository) {
        return new OrderService(orderRepository);
    }
}
