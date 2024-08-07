package com.dyx.ordering.basedao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyx.ordering.basedao.entity.FoodEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseFoodMapper extends BaseMapper<FoodEntity> {
}
