package com.dyx.ordering.basedao.entity.converter;

import com.dyx.ordering.basedao.dto.WindowsDTO;
import com.dyx.ordering.basedao.entity.WindowsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WindowsEntityConverter extends BaseObjectConverter<WindowsEntity, WindowsDTO> {
    WindowsEntityConverter INSTANCE = Mappers.getMapper(WindowsEntityConverter.class);
}
