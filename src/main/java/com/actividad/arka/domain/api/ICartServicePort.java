package com.actividad.arka.domain.api;

import com.actividad.arka.domain.model.Cart;

import java.util.List;

public interface ICartServicePort {
    List<Cart> getAbandonedCarts();

}
