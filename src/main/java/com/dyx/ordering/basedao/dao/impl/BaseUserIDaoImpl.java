package com.dyx.ordering.basedao.dao.impl;

import com.dyx.ordering.basedao.dao.BaseUserIDao;
import com.dyx.ordering.basedao.entity.UserEntity;
import com.dyx.ordering.basedao.mapper.BaseUserMapper;
import com.dyx.ordering.common.dao.Impl.IDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseUserIDaoImpl extends IDaoImpl<BaseUserMapper, UserEntity> implements BaseUserIDao {
}
