package com.dyx.ordering.baseseriver.service.impl;

import com.dyx.ordering.baseseriver.entity.OrderEntity;
import com.dyx.ordering.baseseriver.mapper.BaseOrderMapper;
import com.dyx.ordering.baseseriver.service.BaseOrderIDao;
import com.dyx.ordering.common.dao.Impl.IDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseOrderIDaoImpl extends IDaoImpl<BaseOrderMapper, OrderEntity> implements BaseOrderIDao {
}
