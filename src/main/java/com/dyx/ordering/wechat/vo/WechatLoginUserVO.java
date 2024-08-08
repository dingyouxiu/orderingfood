package com.dyx.ordering.wechat.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "微信用户信息")
public class WechatLoginUserVO {
    @ApiModelProperty("微信用户唯一标识")
    private String openid;

    @ApiModelProperty("会话密钥")
    private String session_key;

    @ApiModelProperty("用户在开放平台的唯一标识符")
    private String unionid;

    @ApiModelProperty("错误代码")
    private Integer errcode;

    @ApiModelProperty("错误信息")
    private String errmsg;
}
