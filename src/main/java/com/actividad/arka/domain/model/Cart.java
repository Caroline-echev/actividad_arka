package com.actividad.arka.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Cart {
    private Long id;
    private Client client;
    private List<Product> products;
    private boolean isAbandoned;

}
