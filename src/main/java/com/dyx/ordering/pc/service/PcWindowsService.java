package com.dyx.ordering.pc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.basedao.dto.WindowsDTO;
import com.dyx.ordering.pc.query.PcWindowsQuery;

import java.util.List;

public interface PcWindowsService {

    Boolean saveBath(List<WindowsDTO> windowsDTOList);

    Boolean deleteBath(List<Long> windowsIdList);

    WindowsDTO edit(WindowsDTO windowsDTO);

    IPage<WindowsDTO> queryPage(PcWindowsQuery windowsQuery);
}
