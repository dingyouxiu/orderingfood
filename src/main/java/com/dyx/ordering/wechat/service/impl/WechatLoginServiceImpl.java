package com.dyx.ordering.wechat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyx.ordering.basedao.entity.UserEntity;
import com.dyx.ordering.wechat.mapper.WechatLoginMapper;
import com.dyx.ordering.wechat.service.WechatLoginService;
import org.springframework.stereotype.Service;

@Service
public class WechatLoginServiceImpl extends ServiceImpl<WechatLoginMapper, UserEntity> implements WechatLoginService {

}
