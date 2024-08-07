package com.dyx.ordering.basedao.entity.converter;

import com.dyx.ordering.basedao.dto.OrderFoodDTO;
import com.dyx.ordering.basedao.entity.OrderFoodEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderFoodEntityConverter extends BaseObjectConverter<OrderFoodEntity, OrderFoodDTO> {
    OrderFoodEntityConverter INSTANCE = Mappers.getMapper(OrderFoodEntityConverter.class);
}
