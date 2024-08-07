package com.dyx.ordering.pc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dyx.ordering.basedao.dto.WindowsDTO;
import com.dyx.ordering.basedao.entity.WindowsEntity;
import com.dyx.ordering.basedao.entity.converter.WindowsEntityConverter;
import com.dyx.ordering.basedao.service.BaseWindowsIDao;
import com.dyx.ordering.common.utils.PageUtil;
import com.dyx.ordering.pc.query.PcWindowsQuery;
import com.dyx.ordering.pc.service.PcWindowsService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class PcWindowsServiceImpl implements PcWindowsService {

    @Autowired
    private BaseWindowsIDao baseWindowsIDao;

    /**
     * 新增
     * @param windowsDTOList
     * @return
     */
    @Override
    @Transactional
    public Boolean saveBath(List<WindowsDTO> windowsDTOList) {
        if (CollectionUtils.isEmpty(windowsDTOList)) {
            return Boolean.FALSE;
        }

        List<WindowsEntity> windowsEntityList = WindowsEntityConverter.INSTANCE.toEntityList(windowsDTOList);

        return baseWindowsIDao.saveBatch(windowsEntityList);
    }

    /**
     * 删除-批量
     * @param windowsIdList
     * @return
     */
    @Override
    @Transactional
    public Boolean deleteBath(List<Long> windowsIdList) {
        if (CollectionUtils.isEmpty(windowsIdList)) {
            return Boolean.FALSE;
        }

        return baseWindowsIDao.removeByIds(windowsIdList);
    }

    /**
     * 编辑
     * @param windowsDTO
     * @return
     */
    @Override
    @Transactional
    public WindowsDTO edit(WindowsDTO windowsDTO) {
        if (Objects.isNull(windowsDTO)) {
            return windowsDTO;
        }

        baseWindowsIDao.updateById(windowsDTO);

        return windowsDTO;
    }

    /**
     * 分页查询
     * @param wechatWindowsQuery
     * @return
     */
    @Override
    public IPage<WindowsDTO> queryPage(PcWindowsQuery wechatWindowsQuery) {

        IPage<WindowsEntity> windowsEntityIPage =
                baseWindowsIDao.page(PageUtil.buildPage(wechatWindowsQuery), buildQueryWrapper(wechatWindowsQuery));
        IPage<WindowsDTO> windowsDTOIPage = WindowsEntityConverter.INSTANCE.toIPageDTO(windowsEntityIPage);

        expandAttributes(windowsDTOIPage.getRecords());

        return windowsDTOIPage;
    }

    private LambdaQueryWrapper<WindowsEntity> buildQueryWrapper(PcWindowsQuery query){
        return Wrappers.<WindowsEntity>lambdaQuery()
                ;
    }

    private void expandAttributes(List<WindowsDTO> windowsDTOList) {
        if (CollectionUtils.isEmpty(windowsDTOList)) {
            return;
        }

        for (WindowsDTO windowsDTO : windowsDTOList) {

        }
    }

    @Override
    public BaseWindowsIDao getBaseIDao() {
        return this.baseWindowsIDao;
    }
}
