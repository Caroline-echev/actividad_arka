
package com.actividad.arka.adapters.driven.mapper;

import com.actividad.arka.adapters.driven.entity.ProductEntity;
import com.actividad.arka.domain.model.Product;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IProductEntityMapper {
    Product productEntityToProduct(ProductEntity productEntity);
}

