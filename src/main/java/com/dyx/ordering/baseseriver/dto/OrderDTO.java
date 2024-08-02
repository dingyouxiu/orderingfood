package com.dyx.ordering.baseseriver.dto;

import com.dyx.ordering.baseseriver.entity.OrderEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDTO extends OrderEntity {

    @ApiModelProperty(value = "下单用户姓名")
    private String openName;

    @ApiModelProperty(value = "创建人姓名")
    private String createUserName;

    @ApiModelProperty(value = "更新人姓名")
    private String updateUserName;

}
