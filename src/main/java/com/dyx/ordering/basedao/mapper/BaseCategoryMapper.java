package com.dyx.ordering.basedao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyx.ordering.basedao.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseCategoryMapper extends BaseMapper<CategoryEntity> {
}
