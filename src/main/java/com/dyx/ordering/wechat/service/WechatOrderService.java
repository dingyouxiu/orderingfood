package com.dyx.ordering.wechat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.basedao.dao.BaseOrderIDao;
import com.dyx.ordering.basedao.dto.OrderDTO;
import com.dyx.ordering.common.service.BaseMouldService;
import com.dyx.ordering.wechat.query.WechatOrderQuery;

import java.util.List;

public interface WechatOrderService extends BaseMouldService<BaseOrderIDao> {
    Boolean saveBath(List<OrderDTO> orderDTOList);

    Boolean deleteBath(List<Long> orderIdList);

    Boolean edit(OrderDTO orderDTO);

    IPage<OrderDTO> queryPage(WechatOrderQuery orderQuery);

    OrderDTO addOns(OrderDTO orderDTO);

    OrderDTO purchase(OrderDTO orderDTO);
}
