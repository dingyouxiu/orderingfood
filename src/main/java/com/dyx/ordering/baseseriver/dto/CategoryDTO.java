package com.dyx.ordering.baseseriver.dto;

import com.dyx.ordering.baseseriver.entity.CategoryEntity;
import com.dyx.ordering.baseseriver.entity.FoodEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryDTO extends CategoryEntity {

    @ApiModelProperty(value = "创建人姓名")
    private String createUserName;

    @ApiModelProperty(value = "更新人姓名")
    private String updateUserName;

}
