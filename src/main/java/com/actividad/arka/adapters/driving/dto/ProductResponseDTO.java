package com.actividad.arka.adapters.driving.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private int stock;
    private String categoryName;
}
