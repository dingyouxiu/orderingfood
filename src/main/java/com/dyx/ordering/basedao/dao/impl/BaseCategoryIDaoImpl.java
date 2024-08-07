package com.dyx.ordering.basedao.dao.impl;

import com.dyx.ordering.basedao.entity.CategoryEntity;
import com.dyx.ordering.basedao.mapper.BaseCategoryMapper;
import com.dyx.ordering.basedao.dao.BaseCategoryIDao;
import com.dyx.ordering.common.dao.Impl.IDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseCategoryIDaoImpl extends IDaoImpl<BaseCategoryMapper, CategoryEntity> implements BaseCategoryIDao {
}
