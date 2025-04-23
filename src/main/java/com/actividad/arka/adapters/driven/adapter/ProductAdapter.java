package com.actividad.arka.adapters.driven.adapter;

import com.actividad.arka.adapters.driven.mapper.IProductEntityMapper;
import com.actividad.arka.adapters.driven.repository.IProductRepository;
import com.actividad.arka.domain.model.Product;
import com.actividad.arka.domain.spi.IProductPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductAdapter implements IProductPersistencePort {
    // S: Solo se encarga de interactuar con la base de datos para la entidad ProductEntity
    // I: Esta clase implementa solo los métodos definidos por IProductPersistencePort
    private final IProductRepository productRepository;
    private final IProductEntityMapper productEntityMapper;

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId).stream().map(productEntityMapper::productEntityToProduct).toList();
    }

    @Override
    public Product getProductyById(Long productId) {
        return productEntityMapper.productEntityToProduct(productRepository.findById(productId).orElse(null));
    }
}

