package com.thoughtworks.shopping.service;

import com.thoughtworks.shopping.domain.Product;
import com.thoughtworks.shopping.dto.ProductDto;
import com.thoughtworks.shopping.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    final private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll().stream()
                .map(ele -> Product.builder()
                        .name(ele.getName())
                        .price(ele.getPrice())
                        .unit(ele.getUnit())
                        .img(ele.getImg()).build()).collect(Collectors.toList());
    }


    public int addProduct(Product product) {
        ProductDto productDto = ProductDto.builder()
                .name(product.getName())
                .img(product.getImg())
                .price(product.getPrice())
                .unit(product.getUnit()).build();
        productRepository.save(productDto);
        return 1;
    }
}
