package com.thoughtworks.shopping.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.shopping.domain.Product;
import com.thoughtworks.shopping.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void setup() {

    }

    @Test
    public void should_add_product_when_addProduct_given_new_product() throws Exception {
        Product product = Product.builder().name("kele").img(" ").price(12).unit("元").build();
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/product").content(objectMapper.writeValueAsString(product)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void should_get_products_when_getProducts() throws Exception {
        Product product1 = Product.builder().name("kele").img(" ").price(12).unit("元").build();
        Product product2 = Product.builder().name("linshi").img(" ").price(12).unit("元").build();
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/product").content(objectMapper.writeValueAsString(product1)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        mockMvc.perform(post("/product").content(objectMapper.writeValueAsString(product2)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("kele")));
    }

}