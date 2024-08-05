package com.dyx.ordering.wechat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.baseseriver.dto.CategoryDTO;
import com.dyx.ordering.wechat.query.WechatCategoryQuery;

import java.util.List;

public interface WechatCategoryService {

    Boolean saveBath(List<CategoryDTO> categoryDTOList);

    Boolean deleteBath(List<Long> categoryIdList);

    CategoryDTO edit(CategoryDTO categoryDTO);

    IPage<CategoryDTO> queryPage(WechatCategoryQuery categoryQuery);
}
