package com.dyx.ordering.wechat.controller;

import cn.hutool.core.bean.BeanUtil;
import com.dyx.ordering.common.constant.WechatOpenAPIConstants;
import com.dyx.ordering.common.utils.HttpUtils;
import com.dyx.ordering.common.utils.StringReplaceUtils;
import com.dyx.ordering.result.Result;
import com.dyx.ordering.wechat.controller.dto.UserDTO;
import com.dyx.ordering.wechat.entity.UserEntity;
import com.dyx.ordering.wechat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wechat")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public Result<UserDTO> login() {
        UserEntity userEntity = new UserEntity();
        boolean save = loginService.save(userEntity);

        String loginApi = WechatOpenAPIConstants.LOGIN_API;
        Map<String,Object> stationData = new HashMap<>();
        stationData.put(WechatOpenAPIConstants.APP_ID,"2222");
        stationData.put(WechatOpenAPIConstants.SECRET,"2222");
        String loginApiUrl = StringReplaceUtils.placeholderSubstitution(loginApi, stationData);
        String s = HttpUtils.get(loginApiUrl);

        return Result.success();
    }

}
