package com.thoughtworks.shopping.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @NotNull
    private String name;
    private int price;
    private String unit;
    private String img;

}
