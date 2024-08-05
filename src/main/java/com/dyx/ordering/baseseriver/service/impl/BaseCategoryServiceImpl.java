package com.dyx.ordering.baseseriver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyx.ordering.baseseriver.entity.CategoryEntity;
import com.dyx.ordering.baseseriver.mapper.BaseCategoryMapper;
import com.dyx.ordering.baseseriver.service.BaseCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BaseCategoryServiceImpl<T> extends ServiceImpl<BaseCategoryMapper, CategoryEntity> implements BaseCategoryService {

    @Resource
    protected T baseService;

}
