package com.dyx.ordering.baseseriver.service.impl;

import com.dyx.ordering.baseseriver.entity.WindowsEntity;
import com.dyx.ordering.baseseriver.mapper.BaseWindowsMapper;
import com.dyx.ordering.baseseriver.service.BaseWindowsIDao;
import com.dyx.ordering.common.dao.Impl.IDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseWindowsIDaoImpl extends IDaoImpl<BaseWindowsMapper, WindowsEntity> implements BaseWindowsIDao {
}
