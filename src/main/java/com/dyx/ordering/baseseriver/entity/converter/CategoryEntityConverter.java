package com.dyx.ordering.baseseriver.entity.converter;

import com.dyx.ordering.baseseriver.dto.CategoryDTO;
import com.dyx.ordering.baseseriver.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryEntityConverter extends BaseObjectConverter<CategoryEntity, CategoryDTO> {
    CategoryEntityConverter INSTANCE = Mappers.getMapper(CategoryEntityConverter.class);
}
