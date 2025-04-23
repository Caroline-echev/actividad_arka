package com.actividad.arka.adapters.driven.repository;

import com.actividad.arka.adapters.driven.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderRepository   extends JpaRepository<OrderEntity, Long> {
    @Query("SELECT o FROM OrderEntity o JOIN o.products p WHERE p.id = :productId")
    List<OrderEntity> findByProductId(Long productId);

    List<OrderEntity> findByOrderDateBetween(LocalDateTime start, LocalDateTime end);
    List<OrderEntity> findByClient_Id(Long clientId);
}

