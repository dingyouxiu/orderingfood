package com.dyx.ordering.baseseriver.service.impl;

import com.dyx.ordering.baseseriver.entity.OrderFoodEntity;
import com.dyx.ordering.baseseriver.mapper.BaseOrderFoodMapper;
import com.dyx.ordering.baseseriver.service.BaseOrderFoodIDao;
import com.dyx.ordering.common.dao.Impl.IDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseOrderFoodIDaoImpl extends IDaoImpl<BaseOrderFoodMapper, OrderFoodEntity> implements BaseOrderFoodIDao {
}
