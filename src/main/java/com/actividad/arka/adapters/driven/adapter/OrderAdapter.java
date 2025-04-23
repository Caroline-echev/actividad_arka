package com.actividad.arka.adapters.driven.adapter;

import com.actividad.arka.adapters.driven.mapper.IOrderEntityMapper;
import com.actividad.arka.adapters.driven.repository.IOrderRepository;
import com.actividad.arka.domain.model.Order;
import com.actividad.arka.domain.spi.IOrderPersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@RequiredArgsConstructor
public class OrderAdapter implements IOrderPersistencePort {

    private final IOrderRepository orderRepository;
    private final IOrderEntityMapper orderEntityMapper;
    @Override
    public List<Order> getOrdersByProduct(Long productId) {
        return orderRepository.findByProductId(productId).stream().map(orderEntityMapper::orderEntityToOrder).toList();
    }
    @Override
    public List<Order> getOrdersByDateRange(LocalDateTime from, LocalDateTime to) {
        return orderRepository
                .findByOrderDateBetween(from, to)
                .stream()
                .map(orderEntityMapper::orderEntityToOrder)
                .toList();
    }
    @Override
    public List<Order> getOrdersByClient(Long clientId) {         // ← nuevo
        return orderRepository.findByClient_Id(clientId)
                .stream().map(orderEntityMapper::orderEntityToOrder).toList();
    }
}
