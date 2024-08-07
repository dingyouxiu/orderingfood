package com.dyx.ordering.basedao.entity.converter;

import com.dyx.ordering.basedao.dto.CategoryDTO;
import com.dyx.ordering.basedao.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryEntityConverter extends BaseObjectConverter<CategoryEntity, CategoryDTO> {
    CategoryEntityConverter INSTANCE = Mappers.getMapper(CategoryEntityConverter.class);
}
