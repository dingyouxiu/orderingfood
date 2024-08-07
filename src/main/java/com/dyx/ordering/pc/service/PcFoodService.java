package com.dyx.ordering.pc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.basedao.dto.FoodDTO;
import com.dyx.ordering.basedao.dao.BaseFoodIDao;
import com.dyx.ordering.common.service.BaseMouldService;
import com.dyx.ordering.pc.query.PcFoodQuery;

import java.util.List;

public interface PcFoodService extends BaseMouldService<BaseFoodIDao> {

    Boolean saveBath(List<FoodDTO> foodDTOList);

    Boolean deleteBath(List<Long> foodIdList);

    FoodDTO edit(FoodDTO foodDTO);

    IPage<FoodDTO> queryPage(PcFoodQuery foodQuery);

    List<FoodDTO> queryList(PcFoodQuery foodQuery);

    BaseFoodIDao getBaseFoodIDao();
}
