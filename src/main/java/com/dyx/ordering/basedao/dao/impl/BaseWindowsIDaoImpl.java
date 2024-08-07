package com.dyx.ordering.basedao.dao.impl;

import com.dyx.ordering.basedao.entity.WindowsEntity;
import com.dyx.ordering.basedao.mapper.BaseWindowsMapper;
import com.dyx.ordering.basedao.dao.BaseWindowsIDao;
import com.dyx.ordering.common.dao.Impl.IDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseWindowsIDaoImpl extends IDaoImpl<BaseWindowsMapper, WindowsEntity> implements BaseWindowsIDao {
}
