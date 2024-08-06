package com.dyx.ordering.pc.controller;

import com.dyx.ordering.baseseriver.dto.UserDTO;
import com.dyx.ordering.baseseriver.entity.UserEntity;
import com.dyx.ordering.common.constant.WechatOpenAPIConstants;
import com.dyx.ordering.common.utils.HttpUtil;
import com.dyx.ordering.common.utils.StringReplaceUtil;
import com.dyx.ordering.pc.service.PcLoginService;
import com.dyx.ordering.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pc")
public class PcLoginController {

    @Autowired
    private PcLoginService loginService;

    @GetMapping("/login")
    public Result<UserDTO> login() {
        UserEntity userEntity = new UserEntity();
        boolean save = loginService.save(userEntity);

        String loginApi = WechatOpenAPIConstants.LOGIN_API;
        Map<String,Object> stationData = new HashMap<>();
        stationData.put(WechatOpenAPIConstants.APP_ID,"2222");
        stationData.put(WechatOpenAPIConstants.SECRET,"2222");
        String loginApiUrl = StringReplaceUtil.placeholderSubstitution(loginApi, stationData);
        String s = HttpUtil.get(loginApiUrl);

        return Result.success();
    }

}
