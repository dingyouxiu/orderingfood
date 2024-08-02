package com.dyx.ordering.baseseriver.entity.converter;

import com.dyx.ordering.baseseriver.dto.OrderDTO;
import com.dyx.ordering.baseseriver.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderEntityConverter {
    OrderEntityConverter INSTANCE = Mappers.getMapper(OrderEntityConverter.class);

    OrderDTO toDTO(OrderEntity orderEntity);

    List<OrderDTO> toDTOList(List<OrderEntity> orderEntityList);

    List<OrderEntity> toEntityList(List<OrderDTO> orderDTOList);

    OrderEntity toEntity(OrderDTO orderDTO);

}
