package com.actividad.arka.adapters.driven.adapter;

import com.actividad.arka.adapters.driven.mapper.ICategoryEntityMapper;
import com.actividad.arka.adapters.driven.repository.ICategoryRepository;
import com.actividad.arka.domain.model.Category;
import com.actividad.arka.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryAdapter implements ICategoryPersistencePort{
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;


    @Override
    public Category getCategoryById(Long id) {
        return categoryEntityMapper.categoryEntityToCategory(categoryRepository.findById(id).orElse(null));
    }
}
