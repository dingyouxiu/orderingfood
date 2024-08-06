package com.dyx.ordering.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dyx.ordering.app.query.AppWindowsQuery;
import com.dyx.ordering.app.service.AppWindowsService;
import com.dyx.ordering.baseseriver.dto.WindowsDTO;
import com.dyx.ordering.baseseriver.entity.WindowsEntity;
import com.dyx.ordering.baseseriver.entity.converter.WindowsEntityConverter;
import com.dyx.ordering.baseseriver.service.impl.BaseWindowsServiceImpl;
import com.dyx.ordering.common.utils.PageUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class AppWindowsServiceImpl extends BaseWindowsServiceImpl implements AppWindowsService {

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

        return this.saveBatch(windowsEntityList);
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

        return this.removeByIds(windowsIdList);
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

        this.updateById(windowsDTO);

        return windowsDTO;
    }

    /**
     * 分页查询
     * @param wechatWindowsQuery
     * @return
     */
    @Override
    public IPage<WindowsDTO> queryPage(AppWindowsQuery wechatWindowsQuery) {

        IPage<WindowsEntity> windowsEntityIPage =
                this.page(PageUtil.buildPage(wechatWindowsQuery), buildQueryWrapper(wechatWindowsQuery));
        IPage<WindowsDTO> windowsDTOIPage = WindowsEntityConverter.INSTANCE.toIPageDTO(windowsEntityIPage);

        expandAttributes(windowsDTOIPage.getRecords());

        return windowsDTOIPage;
    }

    private LambdaQueryWrapper<WindowsEntity> buildQueryWrapper(AppWindowsQuery query){
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
}
