
package com.actividad.arka.adapters.driven.mapper;

import com.actividad.arka.adapters.driven.entity.OrderEntity;
import com.actividad.arka.adapters.driven.entity.ProductEntity;
import com.actividad.arka.domain.model.Order;
import com.actividad.arka.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = { IClientEntityMapper.class, IProductEntityMapper.class })
public interface IOrderEntityMapper {

    @Mapping(source = "client", target = "client")
    @Mapping(source = "products", target = "products")
    Order orderEntityToOrder(OrderEntity orderEntity);
}