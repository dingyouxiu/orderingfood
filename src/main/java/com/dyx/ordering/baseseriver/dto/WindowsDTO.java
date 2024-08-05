package com.dyx.ordering.baseseriver.dto;

import com.dyx.ordering.baseseriver.entity.OrderFoodEntity;
import com.dyx.ordering.baseseriver.entity.WindowsEntity;
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
