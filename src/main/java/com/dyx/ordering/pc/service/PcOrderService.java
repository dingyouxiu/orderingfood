package com.dyx.ordering.pc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.basedao.dto.OrderDTO;
import com.dyx.ordering.basedao.service.BaseOrderIDao;
import com.dyx.ordering.common.service.BaseMouldService;
import com.dyx.ordering.pc.query.PcOrderQuery;

import java.util.List;

public interface PcOrderService extends BaseMouldService<BaseOrderIDao> {
    Boolean saveBath(List<OrderDTO> orderDTOList);

    Boolean deleteBath(List<Long> orderIdList);

    Boolean edit(OrderDTO orderDTO);

    IPage<OrderDTO> queryPage(PcOrderQuery orderQuery);

    OrderDTO addOns(OrderDTO orderDTO);

    OrderDTO purchase(OrderDTO orderDTO);
}
