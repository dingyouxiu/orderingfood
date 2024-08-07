package com.dyx.ordering.wechat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyx.ordering.basedao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WechatLoginMapper extends BaseMapper<UserEntity> {
}
