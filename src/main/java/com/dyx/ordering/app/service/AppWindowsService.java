package com.dyx.ordering.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.app.query.AppWindowsQuery;
import com.dyx.ordering.basedao.dao.BaseWindowsIDao;
import com.dyx.ordering.basedao.dto.WindowsDTO;
import com.dyx.ordering.common.service.BaseMouldService;

import java.util.List;

public interface AppWindowsService extends BaseMouldService<BaseWindowsIDao> {

    Boolean saveBath(List<WindowsDTO> windowsDTOList);

    Boolean deleteBath(List<Long> windowsIdList);

    WindowsDTO edit(WindowsDTO windowsDTO);

    IPage<WindowsDTO> queryPage(AppWindowsQuery windowsQuery);
}
