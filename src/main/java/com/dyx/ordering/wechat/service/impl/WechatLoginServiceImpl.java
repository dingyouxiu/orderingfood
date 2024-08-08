package com.dyx.ordering.wechat.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dyx.ordering.basedao.dao.BaseUserIDao;
import com.dyx.ordering.basedao.dto.UserDTO;
import com.dyx.ordering.basedao.entity.UserEntity;
import com.dyx.ordering.basedao.entity.converter.UserEntityConverter;
import com.dyx.ordering.common.constant.WechatOpenAPIConstants;
import com.dyx.ordering.common.enums.BaseStatus;
import com.dyx.ordering.common.utils.HttpUtil;
import com.dyx.ordering.common.utils.StringReplaceUtil;
import com.dyx.ordering.exception.ServiceException;
import com.dyx.ordering.wechat.mapper.WechatLoginMapper;
import com.dyx.ordering.wechat.service.WechatLoginService;
import com.dyx.ordering.wechat.vo.WechatLoginUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class WechatLoginServiceImpl implements WechatLoginService {

    @Autowired
    private BaseUserIDao baseUserIDao;

    @Override
    @Transactional
    public UserDTO login(UserDTO userDTO) {
        // 获取微信用户唯一标识
        String loginApi = WechatOpenAPIConstants.LOGIN_API;
        Map<String,Object> stationData = new HashMap<>();
        stationData.put(WechatOpenAPIConstants.APP_ID,"2222");
        stationData.put(WechatOpenAPIConstants.SECRET,"2222");
        stationData.put(WechatOpenAPIConstants.CODE,"2222");
        String loginApiUrl = StringReplaceUtil.placeholderSubstitution(loginApi, stationData);
        String wechatUserJsonStr = HttpUtil.get(loginApiUrl);
        WechatLoginUserVO wechatLoginUserVO =
                JSONUtil.toBean(JSONUtil.parseObj(wechatUserJsonStr), WechatLoginUserVO.class);

        // 判断用户是否存在
        UserEntity userEntity =
                baseUserIDao.getOne(
                        Wrappers.<UserEntity>lambdaQuery()
                                .eq(UserEntity::getOpenId, wechatLoginUserVO.getOpenid())
                );
        if (Objects.isNull(userEntity)) {
            throw new ServiceException(BaseStatus.LOGIN_USER_NOT_EXIST_ERROR);
        }

        // TODO 生成token

        return UserEntityConverter.INSTANCE.toDTO(userEntity);
    }

    @Override
    @Transactional
    public UserDTO register(UserDTO userDTO) {
        boolean saveResult = baseUserIDao.save(UserEntityConverter.INSTANCE.toEntity(userDTO));

        if (!saveResult) {
            throw new ServiceException(BaseStatus.LOGIN_USER_REGISTER_ERROR);
        }

        return userDTO;
    }

    @Override
    public BaseUserIDao getBaseIDao() {
        return this.baseUserIDao;
    }
}
