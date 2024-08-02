package com.dyx.ordering.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Query {

    @ApiModelProperty(value = "当前页")
    private Integer current;

    @ApiModelProperty(value = "每页的数量")
    private Integer size;

}