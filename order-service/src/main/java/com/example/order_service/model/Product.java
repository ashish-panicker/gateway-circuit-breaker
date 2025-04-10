package com.example.order_service.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private String productId;
    private String name;
    private String description;
    private double price;
}
