package com.dyx.ordering.basedao.entity.converter;

import com.dyx.ordering.basedao.dto.UserDTO;
import com.dyx.ordering.basedao.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityConverter extends BaseObjectConverter<UserEntity, UserDTO> {
    UserEntityConverter INSTANCE = Mappers.getMapper(UserEntityConverter.class);
}
