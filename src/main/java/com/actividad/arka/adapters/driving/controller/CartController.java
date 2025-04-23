
package com.actividad.arka.adapters.driving.controller;

import com.actividad.arka.adapters.driving.dto.CartResponseDTO;
import com.actividad.arka.adapters.driving.mapper.ICartDtoMapper;
import com.actividad.arka.domain.api.ICartServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartController {
    // S: Este controlador solo se encarga de manejar las peticiones HTTP relacionadas con carrito
    // D: Depende de abstracciones (interfaces), no de implementaciones concretas
    private final ICartServicePort cartServicePort;
    private final ICartDtoMapper cartDtoMapper;

    @GetMapping("/abandoned")
    public ResponseEntity<List<CartResponseDTO>> getAbandonedCarts() {
        List<CartResponseDTO> carts = cartServicePort.getAbandonedCarts()
                .stream()
                .map(cartDtoMapper::toResponse)
                .toList();
        return ResponseEntity.ok(carts);
    }
}
