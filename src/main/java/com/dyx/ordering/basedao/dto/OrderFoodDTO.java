package com.dyx.ordering.basedao.dto;

import com.dyx.ordering.basedao.entity.OrderFoodEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderFoodDTO extends OrderFoodEntity {

    @ApiModelProperty(value = "创建人姓名")
    private String createUserName;

    @ApiModelProperty(value = "更新人姓名")
    private String updateUserName;

}
