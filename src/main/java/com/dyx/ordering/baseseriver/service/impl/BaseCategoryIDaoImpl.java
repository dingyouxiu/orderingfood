package com.dyx.ordering.baseseriver.service.impl;

import com.dyx.ordering.baseseriver.entity.CategoryEntity;
import com.dyx.ordering.baseseriver.mapper.BaseCategoryMapper;
import com.dyx.ordering.baseseriver.service.BaseCategoryIDao;
import com.dyx.ordering.common.dao.Impl.IDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseCategoryIDaoImpl extends IDaoImpl<BaseCategoryMapper, CategoryEntity> implements BaseCategoryIDao {
}
