package com.dyx.ordering.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyx.ordering.app.mapper.AppLoginMapper;
import com.dyx.ordering.app.service.AppLoginService;
import com.dyx.ordering.basedao.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class AppLoginServiceImpl extends ServiceImpl<AppLoginMapper, UserEntity> implements AppLoginService {

}
