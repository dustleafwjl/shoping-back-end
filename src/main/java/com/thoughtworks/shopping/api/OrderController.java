package com.thoughtworks.shopping.api;


import com.thoughtworks.shopping.service.OrderService;
import com.thoughtworks.shopping.service.ProductService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
}
