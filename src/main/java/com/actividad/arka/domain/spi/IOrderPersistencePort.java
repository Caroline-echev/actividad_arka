package com.actividad.arka.domain.spi;

import com.actividad.arka.domain.model.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderPersistencePort {
    List<Order> getOrdersByProduct(Long productId);
    List<Order> getOrdersByDateRange(LocalDateTime from, LocalDateTime to);
    List<Order> getOrdersByClient(Long clientId);
}
