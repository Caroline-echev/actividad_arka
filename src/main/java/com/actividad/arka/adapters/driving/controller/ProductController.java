package com.actividad.arka.adapters.driving.controller;

import com.actividad.arka.adapters.driving.dto.ProductResponseDTO;
import com.actividad.arka.adapters.driving.mapper.IProductDtoMapper;
import com.actividad.arka.domain.api.IProductServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    // S: Este controlador solo se encarga de manejar las peticiones HTTP relacionadas con productos
    // D: Depende de abstracciones (interfaces), no de implementaciones concretas
    private final IProductServicePort productServicePort;
    private final IProductDtoMapper productDtoMapper;

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByCategory(@PathVariable Long categoryId) {
        List<ProductResponseDTO> products = productServicePort.getProductsByCategory(categoryId)
                .stream()
                .map(productDtoMapper::toResponse)
                .toList();
        return ResponseEntity.ok(products);
    }
}
