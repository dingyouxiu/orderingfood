package com.dyx.ordering.pc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.basedao.dto.OrderFoodDTO;
import com.dyx.ordering.pc.query.PcOrderFoodQuery;

import java.util.List;

public interface PcOrderFoodService {

    Boolean saveBath(List<OrderFoodDTO> orderFoodDTOList);

    Boolean deleteBath(List<Long> orderFoodIdList);

    OrderFoodDTO edit(OrderFoodDTO orderFoodDTO);

    Boolean editBath(List<OrderFoodDTO> orderFoodDTOList);

    IPage<OrderFoodDTO> queryPage(PcOrderFoodQuery orderFoodQuery);

    List<OrderFoodDTO> queryList(PcOrderFoodQuery orderFoodQuery);
}
