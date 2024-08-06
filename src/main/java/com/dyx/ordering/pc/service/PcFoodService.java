package com.dyx.ordering.pc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.baseseriver.dto.FoodDTO;
import com.dyx.ordering.pc.query.PcFoodQuery;

import java.util.List;

public interface PcFoodService {

    Boolean saveBath(List<FoodDTO> foodDTOList);

    Boolean deleteBath(List<Long> foodIdList);

    FoodDTO edit(FoodDTO foodDTO);

    IPage<FoodDTO> queryPage(PcFoodQuery foodQuery);
}
