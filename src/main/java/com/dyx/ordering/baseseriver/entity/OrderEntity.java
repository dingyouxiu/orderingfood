package com.dyx.ordering.baseseriver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dyx.ordering.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@TableName(value = "shop_order")
@ApiModel(description = "订单")
@EqualsAndHashCode(callSuper = true)
public class OrderEntity extends BaseEntity {

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "点餐窗口")
    private Long windowId;

    @ApiModelProperty(value = "商品总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "下单用户")
    private String openId;

    @ApiModelProperty(value = "评论")
    private String comments;

    @ApiModelProperty(value = "订单状态（1支付，2待评价，3已评价）")
    private Integer state;

}
