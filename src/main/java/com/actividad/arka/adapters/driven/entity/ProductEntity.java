package com.actividad.arka.adapters.driven.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private int stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;



}