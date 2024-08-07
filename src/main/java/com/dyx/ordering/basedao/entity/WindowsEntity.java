package com.dyx.ordering.basedao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dyx.ordering.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName(value = "shop_windows")
@ApiModel(description = "窗口表")
@EqualsAndHashCode(callSuper = true)
public class WindowsEntity extends BaseEntity {

    @ApiModelProperty("窗口名称")
    private String name;

    @ApiModelProperty("状态（0，未启用；1启用）")
    private Integer state;

}
