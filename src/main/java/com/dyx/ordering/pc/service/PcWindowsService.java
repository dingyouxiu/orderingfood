package com.dyx.ordering.pc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.basedao.dto.WindowsDTO;
import com.dyx.ordering.basedao.service.BaseWindowsIDao;
import com.dyx.ordering.common.service.BaseMouldService;
import com.dyx.ordering.pc.query.PcWindowsQuery;

import java.util.List;

public interface PcWindowsService extends BaseMouldService<BaseWindowsIDao> {

    Boolean saveBath(List<WindowsDTO> windowsDTOList);

    Boolean deleteBath(List<Long> windowsIdList);

    WindowsDTO edit(WindowsDTO windowsDTO);

    IPage<WindowsDTO> queryPage(PcWindowsQuery windowsQuery);
}
