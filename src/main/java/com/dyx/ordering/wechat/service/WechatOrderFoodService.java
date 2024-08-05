package com.dyx.ordering.wechat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.baseseriver.dto.OrderFoodDTO;
import com.dyx.ordering.wechat.query.WechatOrderFoodQuery;

import java.util.List;

public interface WechatOrderFoodService {

    Boolean saveBath(List<OrderFoodDTO> orderFoodDTOList);

    Boolean deleteBath(List<Long> orderFoodIdList);

    OrderFoodDTO edit(OrderFoodDTO orderFoodDTO);

    Boolean editBath(List<OrderFoodDTO> orderFoodDTOList);

    IPage<OrderFoodDTO> queryPage(WechatOrderFoodQuery orderFoodQuery);

    List<OrderFoodDTO> queryList(WechatOrderFoodQuery orderFoodQuery);
}
