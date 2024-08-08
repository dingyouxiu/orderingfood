package com.dyx.ordering.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("创建人")
    private Long createUser;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新人")
    private Long updateUser;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

}
