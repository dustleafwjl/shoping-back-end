package com.thoughtworks.shopping.repository;

import com.thoughtworks.shopping.dto.ProductDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductDto, Integer> {
    @Override
    List<ProductDto> findAll();

    ProductDto findUserById(int productId);
}
