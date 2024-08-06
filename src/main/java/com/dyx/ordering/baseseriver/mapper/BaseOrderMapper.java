package com.dyx.ordering.baseseriver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyx.ordering.baseseriver.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseOrderMapper extends BaseMapper<OrderEntity> {
}
