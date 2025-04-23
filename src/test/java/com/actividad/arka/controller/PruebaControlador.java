package com.actividad.arka.controller;

import com.actividad.arka.adapters.driving.controller.CartController;
import com.actividad.arka.adapters.driving.controller.OrderController;
import com.actividad.arka.adapters.driving.controller.ProductController;
import com.actividad.arka.adapters.driving.mapper.*;
import com.actividad.arka.domain.api.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class PruebaControlador {

    @Mock private IProductServicePort productService;
    @Mock private IProductDtoMapper productMapper;

    @Mock private IOrderServicePort orderService;
    @Mock private IOrderDtoMapper orderMapper;

    @Mock private ICartServicePort cartService;
    @Mock private ICartDtoMapper cartMapper;

    @InjectMocks private ProductController productController;
    @InjectMocks private OrderController orderController;
    @InjectMocks private CartController cartController;

    @Test
    void debeInyectarControladoresCorrectamente() {
        assertNotNull(productController);
        assertNotNull(orderController);
        assertNotNull(cartController);
    }
}
