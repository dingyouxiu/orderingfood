package com.dyx.ordering.pc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyx.ordering.baseseriver.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PcLoginMapper extends BaseMapper<UserEntity> {
}
