package com.dyx.ordering.basedao.entity.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface BaseObjectConverter<E,T> {

    T toDTO(E entity);

    List<T> toDTOList(List<E> entityList);

    List<E> toEntityList(List<T> tList);

    E toEntity(T foodDTO);

    default IPage<T> toIPageDTO(IPage<E> eIPage) {
        return eIPage.convert(this::toDTO);
    }

}
