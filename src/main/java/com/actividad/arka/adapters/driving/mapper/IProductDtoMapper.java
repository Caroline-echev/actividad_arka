package com.actividad.arka.adapters.driving.mapper;



import com.actividad.arka.adapters.driving.dto.ProductResponseDTO;
import com.actividad.arka.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductDtoMapper {
    @Mapping(source = "category.name", target = "categoryName")
    ProductResponseDTO toResponse(Product product);

}
