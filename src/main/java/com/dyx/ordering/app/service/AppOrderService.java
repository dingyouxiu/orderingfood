package com.dyx.ordering.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.app.query.AppOrderQuery;
import com.dyx.ordering.basedao.dao.BaseOrderIDao;
import com.dyx.ordering.basedao.dto.OrderDTO;
import com.dyx.ordering.common.service.BaseMouldService;

import java.util.List;

public interface AppOrderService extends BaseMouldService<BaseOrderIDao> {
    Boolean saveBath(List<OrderDTO> orderDTOList);

    Boolean deleteBath(List<Long> orderIdList);

    Boolean edit(OrderDTO orderDTO);

    IPage<OrderDTO> queryPage(AppOrderQuery orderQuery);

    OrderDTO addOns(OrderDTO orderDTO);

    OrderDTO purchase(OrderDTO orderDTO);
}
