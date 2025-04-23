package com.actividad.arka.domain.spi;

import com.actividad.arka.domain.model.Cart;

import java.util.List;

public interface ICartPersistencePort {
    List<Cart> getCartsByAbandoned(boolean isAbandoned);
}
