package com.dyx.ordering.baseseriver.entity.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.baseseriver.dto.FoodDTO;
import com.dyx.ordering.baseseriver.entity.FoodEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FoodEntityConverter {
    FoodEntityConverter INSTANCE = Mappers.getMapper(FoodEntityConverter.class);

    FoodDTO toDTO(FoodEntity foodEntity);

    List<FoodDTO> toDTOList(List<FoodEntity> foodEntityList);

    List<FoodEntity> toEntityList(List<FoodDTO> foodDTOList);

    FoodEntity toEntity(FoodDTO foodDTO);

    default IPage<FoodDTO> toIPageDTO(IPage<FoodEntity> foodEntityIPage) {
        return foodEntityIPage.convert(this::toDTO);
    }

}
