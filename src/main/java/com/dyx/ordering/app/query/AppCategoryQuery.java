package com.dyx.ordering.app.query;

import com.dyx.ordering.common.entity.Query;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AppCategoryQuery extends Query {

    @ApiModelProperty(value = "类别")
    private Integer category;

}
