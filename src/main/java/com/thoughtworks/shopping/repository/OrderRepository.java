package com.thoughtworks.shopping.repository;

import com.thoughtworks.shopping.dto.OrderDto;
import com.thoughtworks.shopping.dto.ProductDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends CrudRepository<OrderDto, Integer> {
    @Override
    List<OrderDto> findAll();
}
