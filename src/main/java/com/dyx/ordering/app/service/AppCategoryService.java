package com.dyx.ordering.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.app.query.AppCategoryQuery;
import com.dyx.ordering.baseseriver.dto.CategoryDTO;

import java.util.List;

public interface AppCategoryService {

    Boolean saveBath(List<CategoryDTO> categoryDTOList);

    Boolean deleteBath(List<Long> categoryIdList);

    CategoryDTO edit(CategoryDTO categoryDTO);

    IPage<CategoryDTO> queryPage(AppCategoryQuery categoryQuery);
}
