package com.actividad.arka.controller;

import com.actividad.arka.adapters.driving.controller.ProductController;
import com.actividad.arka.adapters.driving.controller.OrderController;
import com.actividad.arka.adapters.driving.mapper.*;
import com.actividad.arka.domain.api.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PruebaPeticiones {

    private MockMvc mockMvc;

    private final IProductServicePort productService = Mockito.mock(IProductServicePort.class);
    private final IProductDtoMapper productMapper = Mockito.mock(IProductDtoMapper.class);

    private final IOrderServicePort orderService = Mockito.mock(IOrderServicePort.class);
    private final IOrderDtoMapper orderMapper = Mockito.mock(IOrderDtoMapper.class);

    @BeforeEach
    void setup() {
        ProductController productController = new ProductController(productService, productMapper);
        OrderController orderController = new OrderController(orderService, orderMapper);

        mockMvc = MockMvcBuilders.standaloneSetup(productController, orderController).build();
    }

    @Test
    void obtenerProductosPorCategoria() throws Exception {
        when(productService.getProductsByCategory(1L)).thenReturn(List.of());
        mockMvc.perform(get("/products/category/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void obtenerOrdenesPorProducto() throws Exception {
        when(orderService.getOrdersByProduct(1L)).thenReturn(List.of());
        mockMvc.perform(get("/orders/product/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void obtenerOrdenesPorCliente() throws Exception {
        when(orderService.getOrdersByClient(10L)).thenReturn(List.of());
        mockMvc.perform(get("/orders/client/10"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void obtenerOrdenesPorRangoDeFecha() throws Exception {
        LocalDateTime from = LocalDateTime.now().minusDays(5);
        LocalDateTime to = LocalDateTime.now();

        when(orderService.getOrdersByDateRange(from, to)).thenReturn(List.of());

        mockMvc.perform(get("/orders/date-range")
                        .param("from", from.toString())
                        .param("to", to.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void obtenerProductosPorCategoriaNoEncontrada() throws Exception {
        when(productService.getProductsByCategory(999L)).thenReturn(List.of());
        mockMvc.perform(get("/products/category/999"))
                .andExpect(status().isOk());
    }
}
