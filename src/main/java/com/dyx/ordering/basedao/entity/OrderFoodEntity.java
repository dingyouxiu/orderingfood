package com.dyx.ordering.basedao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dyx.ordering.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@TableName(value = "shop_order_food")
@ApiModel(description = "订单商品表")
@EqualsAndHashCode(callSuper = true)
public class OrderFoodEntity extends BaseEntity {

    @ApiModelProperty("关联订单id")
    private Long orderId;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品价格")
    private BigDecimal price;

    @ApiModelProperty("商品简介")
    private String introduce;

    @ApiModelProperty("类别")
    private Integer category;

    @ApiModelProperty("商品图片")
    private String image;

    @ApiModelProperty("商品折扣")
    private BigDecimal discount;

    @ApiModelProperty("购买件数")
    private Integer num;

}
