package com.dyx.ordering.wechat.query;

import com.dyx.ordering.common.entity.Query;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class WechatWindowsQuery extends Query {

    @ApiModelProperty(value = "类别")
    private Integer category;

}
