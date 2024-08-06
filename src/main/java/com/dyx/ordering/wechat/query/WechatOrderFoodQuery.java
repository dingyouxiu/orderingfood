package com.dyx.ordering.wechat.query;

import com.dyx.ordering.common.entity.Query;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class WechatOrderFoodQuery extends Query {

    @ApiModelProperty(value = "类别")
    private Integer category;

    @ApiModelProperty("关联订单id")
    private Long orderId;

}
