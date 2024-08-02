package com.dyx.ordering.wechat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dyx.ordering.baseseriver.dto.FoodDTO;
import com.dyx.ordering.baseseriver.entity.FoodEntity;
import com.dyx.ordering.baseseriver.entity.converter.FoodEntityConverter;
import com.dyx.ordering.baseseriver.service.FoodService;
import com.dyx.ordering.common.utils.PageUtils;
import com.dyx.ordering.wechat.query.WechatFoodQuery;
import com.dyx.ordering.wechat.service.WechatFoodService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WechatFoodServiceImpl implements WechatFoodService {

    @Autowired
    private FoodService foodService;

    @Override
    public IPage<FoodDTO> queryPage(WechatFoodQuery wechatFoodQuery) {

        IPage<FoodEntity> foodEntityIPage =
                foodService.page(PageUtils.buildPage(wechatFoodQuery), buildQueryWrapper(wechatFoodQuery));
        IPage<FoodDTO> foodDTOIPage = FoodEntityConverter.INSTANCE.toIPageDTO(foodEntityIPage);

        expandAttributes(foodDTOIPage.getRecords());

        return foodDTOIPage;
    }

    private LambdaQueryWrapper<FoodEntity> buildQueryWrapper(WechatFoodQuery query){
        return Wrappers.<FoodEntity>lambdaQuery()
                ;
    }

    private void expandAttributes(List<FoodDTO> foodDTOList) {
        if (CollectionUtils.isEmpty(foodDTOList)) {
            return;
        }

        for (FoodDTO foodDTO : foodDTOList) {

        }
    }
}
