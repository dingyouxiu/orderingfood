package com.dyx.ordering.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyx.ordering.baseseriver.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppLoginMapper extends BaseMapper<UserEntity> {
}
