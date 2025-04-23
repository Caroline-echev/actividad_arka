package com.actividad.arka.domain.usecase;

import com.actividad.arka.domain.api.IOrderServicePort;
import com.actividad.arka.domain.exception.notfound.CategoryNotFoundException;
import com.actividad.arka.domain.exception.notfound.ProductNotFoundException;
import com.actividad.arka.domain.model.Order;
import com.actividad.arka.domain.spi.IOrderPersistencePort;
import com.actividad.arka.domain.spi.IProductPersistencePort;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@RequiredArgsConstructor
public class OrderUseCase implements IOrderServicePort {

    private final IProductPersistencePort productPersistencePort;
    private final IOrderPersistencePort orderPersistencePort;

    @Override
    public List<Order> getOrdersByProduct(Long productId) {
        validateFilterProduct(productId);
        return orderPersistencePort.getOrdersByProduct(productId);
    }
    private void validateFilterProduct(Long productId) {
        if (productPersistencePort.getProductyById(productId) == null) {
            throw new ProductNotFoundException("Product not found");
        }
    }

    @Override
    public List<Order> getOrdersByDateRange(LocalDateTime from, LocalDateTime to) {
        return orderPersistencePort.getOrdersByDateRange(from, to);
    }

    @Override
    public List<Order> getOrdersByClient(Long clientId) {
        return orderPersistencePort.getOrdersByClient(clientId);
    }
}
