package com.dyx.ordering.baseseriver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyx.ordering.baseseriver.entity.WindowsEntity;
import com.dyx.ordering.baseseriver.mapper.BaseWindowsMapper;
import com.dyx.ordering.baseseriver.service.BaseWindowsService;
import org.springframework.stereotype.Service;

@Service
public class BaseWindowsServiceImpl extends ServiceImpl<BaseWindowsMapper, WindowsEntity> implements BaseWindowsService {
}
