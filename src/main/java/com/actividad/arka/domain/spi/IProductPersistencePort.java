package com.actividad.arka.domain.spi;

import com.actividad.arka.domain.model.Product;

import java.util.List;

public interface IProductPersistencePort {
    List<Product> getProductsByCategory(Long categoryId);
    Product getProductyById(Long productId);
}
