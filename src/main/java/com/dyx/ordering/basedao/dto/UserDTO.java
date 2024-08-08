package com.dyx.ordering.basedao.dto;

import com.dyx.ordering.basedao.entity.UserEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends UserEntity {

    @ApiModelProperty("wechat 临时code")
    private String wechatTempCode;

}
