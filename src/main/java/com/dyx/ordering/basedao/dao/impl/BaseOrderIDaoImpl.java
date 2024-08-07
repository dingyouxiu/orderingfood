package com.dyx.ordering.basedao.dao.impl;

import com.dyx.ordering.basedao.entity.OrderEntity;
import com.dyx.ordering.basedao.mapper.BaseOrderMapper;
import com.dyx.ordering.basedao.dao.BaseOrderIDao;
import com.dyx.ordering.common.dao.Impl.IDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseOrderIDaoImpl extends IDaoImpl<BaseOrderMapper, OrderEntity> implements BaseOrderIDao {
}
