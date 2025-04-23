package com.actividad.arka.adapters.driving.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartResponseDTO {
    private Long id;
    private String clientName;
    private List<ProductResponseDTO> products;
    private boolean abandoned;
}