package com.thoughtworks.shopping.dto;


import com.thoughtworks.shopping.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @Id
    @GeneratedValue
    private int id;

//    @Column(name = "name")
    private String name;
    private int price;
    private String unit;
    private String img;

}
