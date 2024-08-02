package com.dyx.ordering.wechat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.baseseriver.dto.FoodDTO;
import com.dyx.ordering.wechat.query.WechatFoodQuery;

public interface WechatFoodService {

    IPage<FoodDTO> queryPage(WechatFoodQuery foodQuery);

}
