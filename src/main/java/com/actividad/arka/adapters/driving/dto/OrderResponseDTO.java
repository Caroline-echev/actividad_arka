package com.actividad.arka.adapters.driving.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class OrderResponseDTO {
    private Long id;
    private String clientName;
    private List<ProductResponseDTO> products;
    private LocalDateTime orderDate;
    private String status;
}
