
package com.actividad.arka.adapters.driven.mapper;

import com.actividad.arka.adapters.driven.entity.CategoryEntity;
import com.actividad.arka.domain.model.Category;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ICategoryEntityMapper {
    Category categoryEntityToCategory(CategoryEntity brandEntity);
}

