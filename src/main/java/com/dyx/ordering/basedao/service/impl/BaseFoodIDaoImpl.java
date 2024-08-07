package com.dyx.ordering.basedao.service.impl;

import com.dyx.ordering.basedao.entity.FoodEntity;
import com.dyx.ordering.basedao.mapper.BaseFoodMapper;
import com.dyx.ordering.basedao.service.BaseFoodIDao;
import com.dyx.ordering.common.dao.Impl.IDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseFoodIDaoImpl extends IDaoImpl<BaseFoodMapper, FoodEntity> implements BaseFoodIDao {
}
