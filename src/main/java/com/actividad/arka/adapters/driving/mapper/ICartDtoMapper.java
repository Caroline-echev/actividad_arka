package com.actividad.arka.adapters.driving.mapper;

import com.actividad.arka.adapters.driving.dto.CartResponseDTO;
import com.actividad.arka.domain.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = IProductDtoMapper.class)
public interface ICartDtoMapper {

    @Mapping(source = "client.name", target = "clientName")
    @Mapping(source = "products", target = "products")
    @Mapping(source = "abandoned", target = "abandoned")
    CartResponseDTO toResponse(Cart cart);
}
