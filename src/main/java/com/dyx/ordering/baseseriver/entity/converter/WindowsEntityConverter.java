package com.dyx.ordering.baseseriver.entity.converter;

import com.dyx.ordering.baseseriver.dto.WindowsDTO;
import com.dyx.ordering.baseseriver.entity.WindowsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WindowsEntityConverter extends BaseObjectConverter<WindowsEntity, WindowsDTO> {
    WindowsEntityConverter INSTANCE = Mappers.getMapper(WindowsEntityConverter.class);
}
