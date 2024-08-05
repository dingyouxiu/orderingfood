package com.dyx.ordering.baseseriver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyx.ordering.baseseriver.entity.OrderFoodEntity;
import com.dyx.ordering.baseseriver.mapper.BaseOrderFoodMapper;
import com.dyx.ordering.baseseriver.service.BaseOrderFoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BaseOrderFoodServiceImpl<T> extends ServiceImpl<BaseOrderFoodMapper, OrderFoodEntity> implements BaseOrderFoodService {

    @Resource
    protected T baseService;

}
