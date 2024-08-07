package com.dyx.ordering.pc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dyx.ordering.basedao.dto.FoodDTO;
import com.dyx.ordering.basedao.entity.FoodEntity;
import com.dyx.ordering.basedao.entity.converter.FoodEntityConverter;
import com.dyx.ordering.basedao.service.BaseFoodIDao;
import com.dyx.ordering.common.utils.PageUtil;
import com.dyx.ordering.pc.query.PcFoodQuery;
import com.dyx.ordering.pc.service.PcFoodService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class PcFoodServiceImpl implements PcFoodService {

    @Autowired
    protected BaseFoodIDao baseFoodIDao;

    public BaseFoodIDao getBaseFoodIDao() {
        return this.baseFoodIDao;
    }

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
    public IPage<FoodDTO> queryPage(PcFoodQuery wechatFoodQuery) {

        IPage<FoodEntity> foodEntityIPage =
                baseFoodIDao.page(PageUtil.buildPage(wechatFoodQuery), buildQueryWrapper(wechatFoodQuery));
        IPage<FoodDTO> foodDTOIPage = FoodEntityConverter.INSTANCE.toIPageDTO(foodEntityIPage);

        expandAttributes(foodDTOIPage.getRecords());

        return foodDTOIPage;
    }

    /**
     * 列表查询
     * @param wechatFoodQuery
     * @return
     */
    @Override
    public List<FoodDTO> queryList(PcFoodQuery wechatFoodQuery) {

        List<FoodEntity> foodEntityList =
                baseFoodIDao.list(buildQueryWrapper(wechatFoodQuery));
        List<FoodDTO> foodDTOList = FoodEntityConverter.INSTANCE.toDTOList(foodEntityList);

        expandAttributes(foodDTOList);

        return foodDTOList;
    }

    private LambdaQueryWrapper<FoodEntity> buildQueryWrapper(PcFoodQuery query){
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

    @Override
    public BaseFoodIDao getBaseIDao() {
        return this.baseFoodIDao;
    }
}
