package com.dyx.ordering.baseseriver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyx.ordering.baseseriver.entity.FoodEntity;
import com.dyx.ordering.baseseriver.mapper.BaseFoodMapper;
import com.dyx.ordering.baseseriver.service.BaseFoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BaseFoodServiceImpl<T> extends ServiceImpl<BaseFoodMapper, FoodEntity> implements BaseFoodService {

    @Resource
    protected T baseService;
}
