package com.dyx.ordering.baseseriver.dto;

import com.dyx.ordering.baseseriver.entity.OrderEntity;
import com.dyx.ordering.common.utils.SerialNumberUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDTO extends OrderEntity {

    @ApiModelProperty(value = "下单用户姓名")
    private String openName;

    @ApiModelProperty(value = "创建人姓名")
    private String createUserName;

    @ApiModelProperty(value = "更新人姓名")
    private String updateUserName;

    @ApiModelProperty(value = "流水码")
    private String serialNumberStr;
    public String getSerialNumberStr() {
        return
                Objects.isNull(this.getSerialNumber()) ? ""
                        : SerialNumberUtil.formatNextSerial(this.getSerialNumber(),4);
    }

    @ApiModelProperty(value = "订单物品")
    private List<OrderFoodDTO> orderFoodDTOList;

}
