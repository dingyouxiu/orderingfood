package com.dyx.ordering.pc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyx.ordering.baseseriver.entity.UserEntity;
import com.dyx.ordering.pc.mapper.PcLoginMapper;
import com.dyx.ordering.pc.service.PcLoginService;
import org.springframework.stereotype.Service;

@Service
public class PcLoginServiceImpl extends ServiceImpl<PcLoginMapper, UserEntity> implements PcLoginService {

}
