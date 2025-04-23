package com.actividad.arka.domain.usecase;

import com.actividad.arka.domain.api.ICartServicePort;
import com.actividad.arka.domain.model.Cart;
import com.actividad.arka.domain.spi.ICartPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CartUseCase implements ICartServicePort {
    private final ICartPersistencePort cartPersistencePort;

    @Override
    public List<Cart> getAbandonedCarts() {
        return cartPersistencePort.getCartsByAbandoned(true);
    }
}