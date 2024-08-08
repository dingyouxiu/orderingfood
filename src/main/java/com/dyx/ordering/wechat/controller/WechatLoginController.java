package com.dyx.ordering.wechat.controller;

import com.dyx.ordering.basedao.dto.UserDTO;
import com.dyx.ordering.result.Result;
import com.dyx.ordering.wechat.service.WechatLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wechat")
@Api(value = "小程序", tags = "登录")
public class WechatLoginController {

    @Autowired
    private WechatLoginService wechatLoginService;

    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "登录")
    public Result<UserDTO> login(@RequestBody UserDTO userDTO) {

        return Result.success(wechatLoginService.login(userDTO));
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册", notes = "注册")
    public Result<UserDTO> register(@RequestBody UserDTO userDTO) {

        return Result.success(wechatLoginService.register(userDTO));
    }

}
