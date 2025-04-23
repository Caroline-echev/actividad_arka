package com.actividad.arka.domain.spi;

import com.actividad.arka.domain.model.Category;

public interface ICategoryPersistencePort {
    Category getCategoryById(Long id);
}
