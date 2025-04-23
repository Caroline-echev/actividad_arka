package com.actividad.arka.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@AllArgsConstructor
@Data
public class Client {
    private Long id;
    private String name;
    private String email;
    private List<Order> orders;
    private Cart cart;

}
