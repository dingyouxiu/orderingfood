package com.dyx.ordering.wechat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dyx.ordering.baseseriver.dto.OrderDTO;
import com.dyx.ordering.baseseriver.entity.OrderEntity;
import com.dyx.ordering.baseseriver.entity.converter.OrderEntityConverter;
import com.dyx.ordering.baseseriver.service.OrderService;
import com.dyx.ordering.common.utils.PageUtil;
import com.dyx.ordering.wechat.query.WechatOrderQuery;
import com.dyx.ordering.wechat.service.WechatOrderService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WechatOrderServiceImpl implements WechatOrderService {

    @Autowired
    private OrderService orderService;

    /**
     * 新增
     * @param orderDTOList
     * @return
     */
    @Override
    public Boolean saveBath(List<OrderDTO> orderDTOList) {
        if (CollectionUtils.isEmpty(orderDTOList)) {
            return Boolean.FALSE;
        }

        List<OrderEntity> orderEntityList = OrderEntityConverter.INSTANCE.toEntityList(orderDTOList);

        return orderService.saveBatch(orderEntityList);
    }

    /**
     * 删除-批量
     * @param orderIdList
     * @return
     */
    @Override
    public Boolean deleteBath(List<Long> orderIdList) {
        if (CollectionUtils.isEmpty(orderIdList)) {
            return Boolean.FALSE;
        }

        return orderService.removeByIds(orderIdList);
    }

    /**
     * 编辑
     * @param orderDTO
     * @return
     */
    @Override
    public Boolean edit(OrderDTO orderDTO) {
        if (Objects.isNull(orderDTO)) {
            return Boolean.FALSE;
        }

        return orderService.updateById(orderDTO);
    }

    /**
     * 分页查询
     * @param orderQuery
     * @return
     */
    @Override
    public IPage<OrderDTO> queryPage(WechatOrderQuery orderQuery) {

        IPage<OrderEntity> orderEntityIPage =
                orderService.page(PageUtil.buildPage(orderQuery), buildQueryWrapper(orderQuery));
        IPage<OrderDTO> orderDTOIPage = OrderEntityConverter.INSTANCE.toIPageDTO(orderEntityIPage);
        expandAttributes(orderDTOIPage.getRecords());

        return orderDTOIPage;
    }

    private LambdaQueryWrapper<OrderEntity> buildQueryWrapper(WechatOrderQuery query){
        return Wrappers.<OrderEntity>lambdaQuery()
                ;
    }

    private void expandAttributes(List<OrderDTO> orderDTOList) {
        if (CollectionUtils.isEmpty(orderDTOList)) {
            return;
        }

        for (OrderDTO orderDTO : orderDTOList) {

        }
    }
}
