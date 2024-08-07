package com.dyx.ordering.wechat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.basedao.dto.WindowsDTO;
import com.dyx.ordering.wechat.query.WechatWindowsQuery;

import java.util.List;

public interface WechatWindowsService {

    Boolean saveBath(List<WindowsDTO> windowsDTOList);

    Boolean deleteBath(List<Long> windowsIdList);

    WindowsDTO edit(WindowsDTO windowsDTO);

    IPage<WindowsDTO> queryPage(WechatWindowsQuery windowsQuery);
}
