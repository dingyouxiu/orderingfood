package com.dyx.ordering.pc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyx.ordering.baseseriver.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PcOrderMapper extends BaseMapper<OrderEntity> {

    /**
     * 获取最大流水号
     * @return
     */
    Long selectSerialNumberMax();

}
