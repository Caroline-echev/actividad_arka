package com.actividad.arka.adapters.driving.controller;

import com.actividad.arka.adapters.driving.dto.OrderResponseDTO;
import com.actividad.arka.adapters.driving.mapper.IOrderDtoMapper;
import com.actividad.arka.domain.api.IOrderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    // S: Este controlador solo se encarga de manejar las peticiones HTTP relacionadas con ordenes
    // D: Depende de abstracciones (interfaces), no de implementaciones concretas
    private final IOrderServicePort orderServicePort;
    private final IOrderDtoMapper orderDtoMapper;

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<OrderResponseDTO>> getOrdersByProduct(@PathVariable Long productId) {
        List<OrderResponseDTO> orders = orderServicePort.getOrdersByProduct(productId)
                .stream()
                .map(orderDtoMapper::toResponse)
                .toList();
        return ResponseEntity.ok(orders);
    }
    @GetMapping("/date-range")
    public ResponseEntity<List<OrderResponseDTO>> getOrdersByDateRange(
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam("to")   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {

        List<OrderResponseDTO> orders = orderServicePort.getOrdersByDateRange(from, to)
                .stream()
                .map(orderDtoMapper::toResponse)
                .toList();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<OrderResponseDTO>> getOrdersByClient(
            @PathVariable Long clientId) {
        List<OrderResponseDTO> orders = orderServicePort
                .getOrdersByClient(clientId)
                .stream()
                .map(orderDtoMapper::toResponse)
                .toList();
        return ResponseEntity.ok(orders);
    }
}

