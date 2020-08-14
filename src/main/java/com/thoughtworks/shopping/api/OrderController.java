package com.thoughtworks.shopping.api;


import com.thoughtworks.shopping.domain.Order;
import com.thoughtworks.shopping.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @CrossOrigin
    @GetMapping("/orders")
    public ResponseEntity getOrders() {
        List<Order> order = this.orderService.getOrders();
        return ResponseEntity.ok(order);
    }
}
