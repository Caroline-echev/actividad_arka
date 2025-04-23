package com.actividad.arka.adapters.driven.mapper;

import com.actividad.arka.adapters.driven.entity.CartEntity;
import com.actividad.arka.domain.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { IClientEntityMapper.class, IProductEntityMapper.class })
public interface ICartEntityMapper {

    Cart toModel(CartEntity entity);
}