package com.dyx.ordering.pc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.baseseriver.dto.OrderDTO;
import com.dyx.ordering.pc.query.PcOrderQuery;

import java.util.List;

public interface PcOrderService {
    Boolean saveBath(List<OrderDTO> orderDTOList);

    Boolean deleteBath(List<Long> orderIdList);

    Boolean edit(OrderDTO orderDTO);

    IPage<OrderDTO> queryPage(PcOrderQuery orderQuery);

    OrderDTO addOns(OrderDTO orderDTO);

    OrderDTO purchase(OrderDTO orderDTO);
}
