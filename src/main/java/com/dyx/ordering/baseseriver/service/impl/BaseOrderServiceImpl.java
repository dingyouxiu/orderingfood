package com.dyx.ordering.baseseriver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyx.ordering.baseseriver.entity.OrderEntity;
import com.dyx.ordering.baseseriver.mapper.BaseOrderMapper;
import com.dyx.ordering.baseseriver.service.BaseOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BaseOrderServiceImpl<T> extends ServiceImpl<BaseOrderMapper, OrderEntity> implements BaseOrderService {

    @Resource
    protected T baseService;

}
