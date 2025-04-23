package com.actividad.arka.adapters.driven.adapter;

import com.actividad.arka.domain.model.Cart;
import com.actividad.arka.domain.spi.ICartPersistencePort;

import java.util.List;
import com.actividad.arka.adapters.driven.mapper.ICartEntityMapper;
import com.actividad.arka.adapters.driven.repository.ICartRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CartAdapter implements ICartPersistencePort {
    // S: Solo se encarga de interactuar con la base de datos para la entidad CartEntity
    // I: Esta clase implementa solo los métodos definidos por ICartPersistencePort
    private final ICartRepository cartRepository;
    private final ICartEntityMapper cartEntityMapper;

    @Override
    public List<Cart> getCartsByAbandoned(boolean isAbandoned) {
        return cartRepository
                .findByIsAbandoned(isAbandoned)
                .stream()
                .map(cartEntityMapper::toModel)
                .toList();
    }

}
