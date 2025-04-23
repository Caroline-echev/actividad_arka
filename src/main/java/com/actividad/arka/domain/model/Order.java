package com.actividad.arka.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
public class Order {
    private Long id;
    private Client client;
    private List<Product> products;
    private LocalDateTime orderDate;
    private String status;

}