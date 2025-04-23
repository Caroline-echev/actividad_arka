package com.actividad.arka.adapters.driven.mapper;

import com.actividad.arka.adapters.driven.entity.ClientEntity;
import com.actividad.arka.domain.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IClientEntityMapper {
    Client clientEntityToClient(ClientEntity clientEntity);
}