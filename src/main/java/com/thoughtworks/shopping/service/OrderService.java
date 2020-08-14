package com.thoughtworks.shopping.service;

import com.thoughtworks.shopping.domain.Order;
import com.thoughtworks.shopping.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    final private OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {

        return orderRepository.findAll().stream()
                .map(ele -> Order.builder()
                        .productId(ele.getProductId())
                        .quantity(ele.getQuantity()).build()).collect(Collectors.toList());
    }
}
