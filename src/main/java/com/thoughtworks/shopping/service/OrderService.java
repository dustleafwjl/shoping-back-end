package com.thoughtworks.shopping.service;

import com.thoughtworks.shopping.repository.OrderRepository;

public class OrderService {
    final private OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
