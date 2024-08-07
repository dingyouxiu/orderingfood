package com.dyx.ordering.pc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dyx.ordering.baseseriver.dto.OrderFoodDTO;
import com.dyx.ordering.baseseriver.entity.OrderFoodEntity;
import com.dyx.ordering.baseseriver.entity.converter.OrderFoodEntityConverter;
import com.dyx.ordering.baseseriver.service.BaseOrderFoodService;
import com.dyx.ordering.common.enums.BaseStatus;
import com.dyx.ordering.common.utils.PageUtil;
import com.dyx.ordering.exception.ServiceException;
import com.dyx.ordering.pc.query.PcOrderFoodQuery;
import com.dyx.ordering.pc.service.PcOrderFoodService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class PcOrderFoodServiceImpl implements PcOrderFoodService {

    @Autowired
    private BaseOrderFoodService baseOrderFoodService;

    /**
     * 新增
     * @param orderFoodDTOList
     * @return
     */
    @Override
    @Transactional
    public Boolean saveBath(List<OrderFoodDTO> orderFoodDTOList) {
        if (CollectionUtils.isEmpty(orderFoodDTOList)) {
            return Boolean.FALSE;
        }

        List<OrderFoodEntity> orderFoodEntityList = OrderFoodEntityConverter.INSTANCE.toEntityList(orderFoodDTOList);

        return baseOrderFoodService.saveBatch(orderFoodEntityList);
    }

    /**
     * 删除-批量
     * @param orderFoodIdList
     * @return
     */
    @Override
    @Transactional
    public Boolean deleteBath(List<Long> orderFoodIdList) {
        if (CollectionUtils.isEmpty(orderFoodIdList)) {
            return Boolean.FALSE;
        }

        return baseOrderFoodService.removeByIds(orderFoodIdList);
    }

    /**
     * 编辑
     * @param orderFoodDTO
     * @return
     */
    @Override
    @Transactional
    public OrderFoodDTO edit(OrderFoodDTO orderFoodDTO) {
        if (Objects.isNull(orderFoodDTO)) {
            return orderFoodDTO;
        }

        boolean updateResult = baseOrderFoodService.updateById(orderFoodDTO);
        if (!updateResult) {
            throw new ServiceException(BaseStatus.ORDER_EDIT_ERROR);
        }

        return orderFoodDTO;
    }

    /**
     * 编辑-批量
     * @param orderFoodDTOList
     */
    @Override
    @Transactional
    public Boolean editBath(List<OrderFoodDTO> orderFoodDTOList) {
        if (CollectionUtils.isEmpty(orderFoodDTOList)) {
            return Boolean.FALSE;
        }

        List<OrderFoodEntity> orderFoodEntityList = OrderFoodEntityConverter.INSTANCE.toEntityList(orderFoodDTOList);

        return baseOrderFoodService.updateBatchById(orderFoodEntityList);
    }

    /**
     * 分页查询
     * @param wechatOrderFoodQuery
     * @return
     */
    @Override
    public IPage<OrderFoodDTO> queryPage(PcOrderFoodQuery wechatOrderFoodQuery) {

        IPage<OrderFoodEntity> orderFoodEntityIPage =
                baseOrderFoodService.page(PageUtil.buildPage(wechatOrderFoodQuery), buildQueryWrapper(wechatOrderFoodQuery));
        IPage<OrderFoodDTO> orderFoodDTOIPage = OrderFoodEntityConverter.INSTANCE.toIPageDTO(orderFoodEntityIPage);

        expandAttributes(orderFoodDTOIPage.getRecords());

        return orderFoodDTOIPage;
    }

    @Override
    public List<OrderFoodDTO> queryList(PcOrderFoodQuery orderFoodQuery) {
        List<OrderFoodEntity> orderFoodEntityList = baseOrderFoodService.list(buildQueryWrapper(orderFoodQuery));

        return OrderFoodEntityConverter.INSTANCE.toDTOList(orderFoodEntityList);
    }

    private LambdaQueryWrapper<OrderFoodEntity> buildQueryWrapper(PcOrderFoodQuery query){
        return Wrappers.<OrderFoodEntity>lambdaQuery()
                .eq(Objects.nonNull(query.getOrderId()), OrderFoodEntity::getOrderId, query.getOrderId())
                .eq(Objects.nonNull(query.getCategory()), OrderFoodEntity::getCategory, query.getCategory())
                ;
    }

    private void expandAttributes(List<OrderFoodDTO> orderFoodDTOList) {
        if (CollectionUtils.isEmpty(orderFoodDTOList)) {
            return;
        }

        for (OrderFoodDTO orderFoodDTO : orderFoodDTOList) {

        }
    }
}
