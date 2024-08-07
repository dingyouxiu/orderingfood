package com.dyx.ordering.wechat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.basedao.dao.BaseFoodIDao;
import com.dyx.ordering.basedao.dto.FoodDTO;
import com.dyx.ordering.common.service.BaseMouldService;
import com.dyx.ordering.wechat.query.WechatFoodQuery;

import java.util.List;

public interface WechatFoodService extends BaseMouldService<BaseFoodIDao> {

    Boolean saveBath(List<FoodDTO> foodDTOList);

    Boolean deleteBath(List<Long> foodIdList);

    FoodDTO edit(FoodDTO foodDTO);

    IPage<FoodDTO> queryPage(WechatFoodQuery foodQuery);
}
