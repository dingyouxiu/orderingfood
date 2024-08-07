package com.dyx.ordering.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.app.query.AppOrderFoodQuery;
import com.dyx.ordering.basedao.dto.OrderFoodDTO;

import java.util.List;

public interface AppOrderFoodService {

    Boolean saveBath(List<OrderFoodDTO> orderFoodDTOList);

    Boolean deleteBath(List<Long> orderFoodIdList);

    OrderFoodDTO edit(OrderFoodDTO orderFoodDTO);

    Boolean editBath(List<OrderFoodDTO> orderFoodDTOList);

    IPage<OrderFoodDTO> queryPage(AppOrderFoodQuery orderFoodQuery);

    List<OrderFoodDTO> queryList(AppOrderFoodQuery orderFoodQuery);
}
