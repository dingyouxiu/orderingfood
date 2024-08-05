package com.dyx.ordering.baseseriver.entity.converter;

import com.dyx.ordering.baseseriver.dto.FoodDTO;
import com.dyx.ordering.baseseriver.entity.FoodEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodEntityConverter extends BaseObjectConverter<FoodEntity, FoodDTO> {
    FoodEntityConverter INSTANCE = Mappers.getMapper(FoodEntityConverter.class);
}
