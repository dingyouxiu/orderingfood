package com.dyx.ordering.basedao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dyx.ordering.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName(value = "shop_user")
@ApiModel(description = "用户表")
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {

    @ApiModelProperty("wx用户唯一标识")
    private String openId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("手机号（微信注册用户，用户名默认为手机号）")
    private String phone;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("用户角色")
    private Long role;
}
