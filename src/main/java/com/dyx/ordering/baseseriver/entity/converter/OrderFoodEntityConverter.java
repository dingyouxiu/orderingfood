package com.dyx.ordering.baseseriver.entity.converter;

import com.dyx.ordering.baseseriver.dto.OrderFoodDTO;
import com.dyx.ordering.baseseriver.entity.OrderFoodEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderFoodEntityConverter extends BaseObjectConverter<OrderFoodEntity, OrderFoodDTO> {
    OrderFoodEntityConverter INSTANCE = Mappers.getMapper(OrderFoodEntityConverter.class);
}
