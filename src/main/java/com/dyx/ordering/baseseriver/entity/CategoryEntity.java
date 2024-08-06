package com.dyx.ordering.baseseriver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dyx.ordering.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName(value = "shop_category")
@ApiModel(description = "商品类别表")
@EqualsAndHashCode(callSuper = true)
public class CategoryEntity extends BaseEntity {

    @ApiModelProperty("上级类别")
    private Long parentCategory;

    @ApiModelProperty("类别")
    private Integer category;

    @ApiModelProperty("类别名称")
    private String categoryName;

}
