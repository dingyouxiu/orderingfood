package com.dyx.ordering.common.dao.Impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyx.ordering.common.dao.IDao;
import org.springframework.stereotype.Service;

@Service
public class IDaoImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IDao<T> {
}
