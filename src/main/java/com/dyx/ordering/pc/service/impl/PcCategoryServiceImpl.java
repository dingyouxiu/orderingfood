package com.dyx.ordering.pc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dyx.ordering.baseseriver.dto.CategoryDTO;
import com.dyx.ordering.baseseriver.entity.CategoryEntity;
import com.dyx.ordering.baseseriver.entity.converter.CategoryEntityConverter;
import com.dyx.ordering.baseseriver.service.BaseCategoryService;
import com.dyx.ordering.common.utils.PageUtil;
import com.dyx.ordering.pc.query.PcCategoryQuery;
import com.dyx.ordering.pc.service.PcCategoryService;
import com.dyx.ordering.pc.service.PcFoodService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PcCategoryServiceImpl implements PcCategoryService {

    @Autowired
    private BaseCategoryService baseCategoryService;
    
    @Autowired
    private PcFoodService pcFoodService;

    /**
     * 新增
     * @param categoryDTOList
     * @return
     */
    @Override
    @Transactional
    public Boolean saveBath(List<CategoryDTO> categoryDTOList) {
        if (CollectionUtils.isEmpty(categoryDTOList)) {
            return Boolean.FALSE;
        }

        List<CategoryEntity> categoryEntityList = CategoryEntityConverter.INSTANCE.toEntityList(categoryDTOList);

        return baseCategoryService.saveBatch(categoryEntityList);
    }

    /**
     * 删除-批量
     * @param categoryIdList
     * @return
     */
    @Override
    @Transactional
    public Boolean deleteBath(List<Long> categoryIdList) {
        if (CollectionUtils.isEmpty(categoryIdList)) {
            return Boolean.FALSE;
        }

        // 判断菜单下是否有商品
        List<CategoryEntity> categoryEntityList = baseCategoryService.listByIds(categoryIdList);
        Map<Long, String> categoryIdAndNameMap =
                categoryEntityList
                        .stream()
                        .collect(Collectors.toMap(CategoryEntity::getId, CategoryEntity::getCategoryName));
//        pcFoodService.


        return baseCategoryService.removeByIds(categoryIdList);
    }

    /**
     * 编辑
     * @param categoryDTO
     * @return
     */
    @Override
    @Transactional
    public CategoryDTO edit(CategoryDTO categoryDTO) {
        if (Objects.isNull(categoryDTO)) {
            return categoryDTO;
        }

        baseCategoryService.updateById(categoryDTO);

        return categoryDTO;
    }

    /**
     * 分页查询
     * @param wechatCategoryQuery
     * @return
     */
    @Override
    public IPage<CategoryDTO> queryPage(PcCategoryQuery wechatCategoryQuery) {

        IPage<CategoryEntity> categoryEntityIPage =
                baseCategoryService.page(PageUtil.buildPage(wechatCategoryQuery), buildQueryWrapper(wechatCategoryQuery));
        IPage<CategoryDTO> categoryDTOIPage = CategoryEntityConverter.INSTANCE.toIPageDTO(categoryEntityIPage);

        expandAttributes(categoryDTOIPage.getRecords());

        return categoryDTOIPage;
    }

    @Override
    public List<CategoryDTO> queryList() {

        List<CategoryEntity> categoryEntityList = baseCategoryService.list();

        return CategoryEntityConverter.INSTANCE.toDTOList(categoryEntityList);
    }

    private LambdaQueryWrapper<CategoryEntity> buildQueryWrapper(PcCategoryQuery query){
        return Wrappers.<CategoryEntity>lambdaQuery()
                ;
    }

    private void expandAttributes(List<CategoryDTO> categoryDTOList) {
        if (CollectionUtils.isEmpty(categoryDTOList)) {
            return;
        }

        for (CategoryDTO categoryDTO : categoryDTOList) {

        }
    }
}
