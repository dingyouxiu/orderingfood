package com.dyx.ordering.wechat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyx.ordering.wechat.entity.UserEntity;
import com.dyx.ordering.wechat.mapper.LoginMapper;
import com.dyx.ordering.wechat.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, UserEntity> implements LoginService {

}
