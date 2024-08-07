package com.dyx.ordering.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dyx.ordering.app.query.AppFoodQuery;
import com.dyx.ordering.app.service.AppFoodService;
import com.dyx.ordering.baseseriver.dto.FoodDTO;
import com.dyx.ordering.baseseriver.entity.FoodEntity;
import com.dyx.ordering.baseseriver.entity.converter.FoodEntityConverter;
import com.dyx.ordering.baseseriver.service.BaseFoodIDao;
import com.dyx.ordering.common.utils.PageUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class AppFoodServiceImpl implements AppFoodService {

    @Autowired
    private BaseFoodIDao baseFoodIDao;

    /**
     * 新增
     * @param foodDTOList
     * @return
     */
    @Override
    @Transactional
    public Boolean saveBath(List<FoodDTO> foodDTOList) {
        if (CollectionUtils.isEmpty(foodDTOList)) {
            return Boolean.FALSE;
        }

        List<FoodEntity> foodEntityList = FoodEntityConverter.INSTANCE.toEntityList(foodDTOList);

        return baseFoodIDao.saveBatch(foodEntityList);
    }

    /**
     * 删除-批量
     * @param foodIdList
     * @return
     */
    @Override
    @Transactional
    public Boolean deleteBath(List<Long> foodIdList) {
        if (CollectionUtils.isEmpty(foodIdList)) {
            return Boolean.FALSE;
        }

        return baseFoodIDao.removeByIds(foodIdList);
    }

    /**
     * 编辑
     * @param foodDTO
     * @return
     */
    @Override
    @Transactional
    public FoodDTO edit(FoodDTO foodDTO) {
        if (Objects.isNull(foodDTO)) {
            return foodDTO;
        }

        baseFoodIDao.updateById(foodDTO);

        return foodDTO;
    }

    /**
     * 分页查询
     * @param wechatFoodQuery
     * @return
     */
    @Override
    @Transactional
    public IPage<FoodDTO> queryPage(AppFoodQuery wechatFoodQuery) {

        IPage<FoodEntity> foodEntityIPage =
                baseFoodIDao.page(PageUtil.buildPage(wechatFoodQuery), buildQueryWrapper(wechatFoodQuery));
        IPage<FoodDTO> foodDTOIPage = FoodEntityConverter.INSTANCE.toIPageDTO(foodEntityIPage);

        expandAttributes(foodDTOIPage.getRecords());

        return foodDTOIPage;
    }

    private LambdaQueryWrapper<FoodEntity> buildQueryWrapper(AppFoodQuery query){
        return Wrappers.<FoodEntity>lambdaQuery()
                .eq(FoodEntity::getCategory,query.getCategory())
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
