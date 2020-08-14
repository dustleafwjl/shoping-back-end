package com.thoughtworks.shopping.api;

import com.thoughtworks.shopping.dto.OrderDto;
import com.thoughtworks.shopping.dto.ProductDto;
import com.thoughtworks.shopping.repository.OrderRepository;
import com.thoughtworks.shopping.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc

class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    void setup() {
        orderRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    public void should_get_all_order_when_get_order_given_get_request() throws Exception {
        ProductDto productDto = ProductDto.builder().name("kele").unit("ping").price(12).img("/asdf").build();
        productDto = this.productRepository.save(productDto);
        OrderDto orderDto1 = OrderDto.builder().quantity(12).productId(productDto.getId()).build();
        this.orderRepository.save(orderDto1);
        OrderDto orderDto2 = OrderDto.builder().quantity(14).productId(productDto.getId()).build();
        orderDto2 = this.orderRepository.save(orderDto2);
        mockMvc.perform(get("/orders"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].quantity", is(orderDto1.getQuantity())))
                .andExpect(jsonPath("$[1].quantity", is(orderDto2.getQuantity())));
    }
}