package com.dyx.ordering.basedao.dto;

import com.dyx.ordering.basedao.entity.WindowsEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class WindowsDTO extends WindowsEntity {

    @ApiModelProperty(value = "创建人姓名")
    private String createUserName;

    @ApiModelProperty(value = "更新人姓名")
    private String updateUserName;

}
