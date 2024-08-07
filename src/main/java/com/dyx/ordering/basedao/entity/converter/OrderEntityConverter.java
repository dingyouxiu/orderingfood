package com.dyx.ordering.basedao.entity.converter;

import com.dyx.ordering.basedao.dto.OrderDTO;
import com.dyx.ordering.basedao.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderEntityConverter extends BaseObjectConverter<OrderEntity, OrderDTO> {
    OrderEntityConverter INSTANCE = Mappers.getMapper(OrderEntityConverter.class);
}
