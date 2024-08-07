package com.dyx.ordering.wechat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.basedao.dao.BaseCategoryIDao;
import com.dyx.ordering.basedao.dto.CategoryDTO;
import com.dyx.ordering.common.service.BaseMouldService;
import com.dyx.ordering.wechat.query.WechatCategoryQuery;

import java.util.List;

public interface WechatCategoryService extends BaseMouldService<BaseCategoryIDao> {

    Boolean saveBath(List<CategoryDTO> categoryDTOList);

    Boolean deleteBath(List<Long> categoryIdList);

    CategoryDTO edit(CategoryDTO categoryDTO);

    IPage<CategoryDTO> queryPage(WechatCategoryQuery categoryQuery);

    List<CategoryDTO> queryList();
}
