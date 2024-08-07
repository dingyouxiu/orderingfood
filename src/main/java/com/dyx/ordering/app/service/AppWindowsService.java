package com.dyx.ordering.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.app.query.AppWindowsQuery;
import com.dyx.ordering.basedao.dto.WindowsDTO;

import java.util.List;

public interface AppWindowsService {

    Boolean saveBath(List<WindowsDTO> windowsDTOList);

    Boolean deleteBath(List<Long> windowsIdList);

    WindowsDTO edit(WindowsDTO windowsDTO);

    IPage<WindowsDTO> queryPage(AppWindowsQuery windowsQuery);
}
