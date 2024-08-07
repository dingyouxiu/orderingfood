package com.dyx.ordering.basedao.dao.impl;

import com.dyx.ordering.basedao.entity.OrderFoodEntity;
import com.dyx.ordering.basedao.mapper.BaseOrderFoodMapper;
import com.dyx.ordering.basedao.dao.BaseOrderFoodIDao;
import com.dyx.ordering.common.dao.Impl.IDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseOrderFoodIDaoImpl extends IDaoImpl<BaseOrderFoodMapper, OrderFoodEntity> implements BaseOrderFoodIDao {
}
