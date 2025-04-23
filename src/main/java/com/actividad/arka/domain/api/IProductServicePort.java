package com.actividad.arka.domain.api;

import com.actividad.arka.domain.model.Product;

import java.util.List;

public interface IProductServicePort {
    List<Product> getProductsByCategory(Long categoryId);
}
