package com.dyx.ordering.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.app.query.AppOrderFoodQuery;
import com.dyx.ordering.basedao.dao.BaseOrderFoodIDao;
import com.dyx.ordering.basedao.dto.OrderFoodDTO;
import com.dyx.ordering.common.service.BaseMouldService;

import java.util.List;

public interface AppOrderFoodService extends BaseMouldService<BaseOrderFoodIDao> {

    Boolean saveBath(List<OrderFoodDTO> orderFoodDTOList);

    Boolean deleteBath(List<Long> orderFoodIdList);

    OrderFoodDTO edit(OrderFoodDTO orderFoodDTO);

    Boolean editBath(List<OrderFoodDTO> orderFoodDTOList);

    IPage<OrderFoodDTO> queryPage(AppOrderFoodQuery orderFoodQuery);

    List<OrderFoodDTO> queryList(AppOrderFoodQuery orderFoodQuery);
}
