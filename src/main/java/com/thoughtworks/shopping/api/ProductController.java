package com.thoughtworks.shopping.api;

import com.thoughtworks.shopping.domain.Product;
import com.thoughtworks.shopping.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin
    @PostMapping("/product")
    public ResponseEntity registerUser(@Valid @RequestBody Product product) {
        int index = productService.addProduct(product);
        return ResponseEntity.created(null).header("index", String.valueOf(index)).build();
    }

    @GetMapping("/products")
    public ResponseEntity getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }
}
