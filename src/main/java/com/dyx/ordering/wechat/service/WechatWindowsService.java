package com.dyx.ordering.wechat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.basedao.dao.BaseWindowsIDao;
import com.dyx.ordering.basedao.dto.WindowsDTO;
import com.dyx.ordering.common.service.BaseMouldService;
import com.dyx.ordering.wechat.query.WechatWindowsQuery;

import java.util.List;

public interface WechatWindowsService extends BaseMouldService<BaseWindowsIDao> {

    Boolean saveBath(List<WindowsDTO> windowsDTOList);

    Boolean deleteBath(List<Long> windowsIdList);

    WindowsDTO edit(WindowsDTO windowsDTO);

    IPage<WindowsDTO> queryPage(WechatWindowsQuery windowsQuery);
}
