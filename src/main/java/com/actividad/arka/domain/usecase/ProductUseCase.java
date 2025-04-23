package com.actividad.arka.domain.usecase;

import com.actividad.arka.domain.api.IProductServicePort;
import com.actividad.arka.domain.exception.notfound.CategoryNotFoundException;
import com.actividad.arka.domain.model.Product;
import com.actividad.arka.domain.spi.ICategoryPersistencePort;
import com.actividad.arka.domain.spi.IProductPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductUseCase implements IProductServicePort {
    // SRP: Esta clase encapsula la lógica de negocio relacionada con productos
    // DIP: Depende de puertos (interfaces), no de detalles de implementación
    private final IProductPersistencePort productPersistencePort;
    private final ICategoryPersistencePort categoryPersistencePort;
    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        validateFilterCategory(categoryId);
        return productPersistencePort.getProductsByCategory(categoryId);
    }
    private void validateFilterCategory(Long categoryId) {
        if (categoryPersistencePort.getCategoryById(categoryId) == null) {
            throw new CategoryNotFoundException("Category not found");
        }
    }
}
