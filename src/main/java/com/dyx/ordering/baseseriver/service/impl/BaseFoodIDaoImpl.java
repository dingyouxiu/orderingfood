package com.dyx.ordering.baseseriver.service.impl;

import com.dyx.ordering.baseseriver.entity.FoodEntity;
import com.dyx.ordering.baseseriver.mapper.BaseFoodMapper;
import com.dyx.ordering.baseseriver.service.BaseFoodIDao;
import com.dyx.ordering.common.dao.Impl.IDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseFoodIDaoImpl extends IDaoImpl<BaseFoodMapper, FoodEntity> implements BaseFoodIDao {
}
