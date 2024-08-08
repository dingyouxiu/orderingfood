package com.dyx.ordering.wechat.service;

import com.dyx.ordering.basedao.dao.BaseUserIDao;
import com.dyx.ordering.basedao.dto.UserDTO;
import com.dyx.ordering.common.service.BaseMouldService;

public interface WechatLoginService extends BaseMouldService<BaseUserIDao> {
    UserDTO login(UserDTO userDTO);

    UserDTO register(UserDTO userDTO);
}
