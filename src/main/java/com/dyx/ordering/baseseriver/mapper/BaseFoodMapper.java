package com.dyx.ordering.baseseriver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyx.ordering.baseseriver.entity.FoodEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseFoodMapper extends BaseMapper<FoodEntity> {
}
