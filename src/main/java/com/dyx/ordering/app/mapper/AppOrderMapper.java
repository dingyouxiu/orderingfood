package com.dyx.ordering.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyx.ordering.basedao.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppOrderMapper extends BaseMapper<OrderEntity> {

    /**
     * 获取最大流水号
     * @return
     */
    Long selectSerialNumberMax();

}
