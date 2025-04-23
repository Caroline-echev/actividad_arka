package com.actividad.arka.adapters.driven.repository;

import com.actividad.arka.adapters.driven.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICartRepository extends JpaRepository<CartEntity, Long> {
    List<CartEntity> findByIsAbandoned(boolean isAbandoned);
}
