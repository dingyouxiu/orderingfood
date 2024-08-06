package com.dyx.ordering.baseseriver.entity.converter;

import com.dyx.ordering.baseseriver.dto.UserDTO;
import com.dyx.ordering.baseseriver.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserEntityConverter extends BaseObjectConverter<UserEntity, UserDTO> {
    UserEntityConverter INSTANCE = Mappers.getMapper(UserEntityConverter.class);
}
