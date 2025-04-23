package com.actividad.arka.adapters.driving.mapper;

import com.actividad.arka.adapters.driving.dto.OrderResponseDTO;
import com.actividad.arka.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring", uses = IProductDtoMapper.class)
public interface IOrderDtoMapper {

    @Mappings({
            @Mapping(source = "client.name", target = "clientName"),
            @Mapping(source = "products", target = "products")
    })
    OrderResponseDTO toResponse(Order order);
}
