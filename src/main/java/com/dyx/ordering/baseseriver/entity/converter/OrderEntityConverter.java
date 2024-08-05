package com.dyx.ordering.baseseriver.entity.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.baseseriver.dto.FoodDTO;
import com.dyx.ordering.baseseriver.dto.OrderDTO;
import com.dyx.ordering.baseseriver.entity.FoodEntity;
import com.dyx.ordering.baseseriver.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderEntityConverter extends BaseObjectConverter<OrderEntity, OrderDTO> {
    OrderEntityConverter INSTANCE = Mappers.getMapper(OrderEntityConverter.class);
}
