package com.dyx.ordering.wechat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.baseseriver.dto.OrderDTO;
import com.dyx.ordering.wechat.query.WechatOrderQuery;

import java.util.List;

public interface WechatOrderService {
    Boolean saveBath(List<OrderDTO> orderDTOList);

    Boolean deleteBath(List<Long> orderIdList);

    Boolean edit(OrderDTO orderDTO);

    IPage<OrderDTO> queryPage(WechatOrderQuery orderQuery);

    OrderDTO addOns(OrderDTO orderDTO);
}
