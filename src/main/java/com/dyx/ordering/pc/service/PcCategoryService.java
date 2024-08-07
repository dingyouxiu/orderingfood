package com.dyx.ordering.pc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.basedao.dto.CategoryDTO;
import com.dyx.ordering.basedao.service.BaseCategoryIDao;
import com.dyx.ordering.common.service.BaseMouldService;
import com.dyx.ordering.pc.query.PcCategoryQuery;

import java.util.List;

public interface PcCategoryService extends BaseMouldService<BaseCategoryIDao> {

    Boolean saveBath(List<CategoryDTO> categoryDTOList);

    Boolean save(CategoryDTO categoryDTOList);

    Boolean deleteBath(List<Integer> categoryIdList);

    CategoryDTO edit(CategoryDTO categoryDTO);

    IPage<CategoryDTO> queryPage(PcCategoryQuery categoryQuery);

    List<CategoryDTO> queryList();
}
