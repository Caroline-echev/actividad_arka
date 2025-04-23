package com.actividad.arka.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private int stock;
    private Category category;

}
