package com.dyx.ordering.pc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.basedao.dto.CategoryDTO;
import com.dyx.ordering.pc.query.PcCategoryQuery;

import java.util.List;

public interface PcCategoryService {

    Boolean saveBath(List<CategoryDTO> categoryDTOList);

    Boolean deleteBath(List<Long> categoryIdList);

    CategoryDTO edit(CategoryDTO categoryDTO);

    IPage<CategoryDTO> queryPage(PcCategoryQuery categoryQuery);

    List<CategoryDTO> queryList();
}
