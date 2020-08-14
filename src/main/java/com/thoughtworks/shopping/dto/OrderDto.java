package com.thoughtworks.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "shoporder")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @Id
    @GeneratedValue
    private int id;

    private int quantity;


    @Column(name = "product_id")
    private int productId;

}
