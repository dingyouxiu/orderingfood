package com.dyx.ordering.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.app.query.AppFoodQuery;
import com.dyx.ordering.basedao.dto.FoodDTO;

import java.util.List;

public interface AppFoodService {

    Boolean saveBath(List<FoodDTO> foodDTOList);

    Boolean deleteBath(List<Long> foodIdList);

    FoodDTO edit(FoodDTO foodDTO);

    IPage<FoodDTO> queryPage(AppFoodQuery foodQuery);
}
