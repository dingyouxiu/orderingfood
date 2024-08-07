package com.dyx.ordering.basedao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dyx.ordering.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@TableName(value = "shop_food")
@ApiModel(description = "商品")
@EqualsAndHashCode(callSuper = true)
public class FoodEntity extends BaseEntity {

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal price;

    @ApiModelProperty(value = "商品简介")
    private String introduce;

    @ApiModelProperty(value = "类别")
    private Integer category;

    @ApiModelProperty(value = "商品图片")
    private String image;

    @ApiModelProperty(value = "商品折扣")
    private BigDecimal discount;

    @ApiModelProperty(value = "商品销量")
    private Integer sales;

}


