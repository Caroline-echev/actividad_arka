package com.actividad.arka.domain.usecase;

import com.actividad.arka.domain.api.ICartServicePort;
import com.actividad.arka.domain.model.Cart;
import com.actividad.arka.domain.spi.ICartPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CartUseCase implements ICartServicePort {
    // S: Esta clase encapsula la lógica de negocio relacionada con carritos
    // D: Depende de puertos (interfaces), no de detalles de implementación
    private final ICartPersistencePort cartPersistencePort;

    @Override
    public List<Cart> getAbandonedCarts() {
        return cartPersistencePort.getCartsByAbandoned(true);
    }
}