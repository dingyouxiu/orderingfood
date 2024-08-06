package com.dyx.ordering.wechat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dyx.ordering.baseseriver.dto.OrderFoodDTO;
import com.dyx.ordering.baseseriver.entity.OrderFoodEntity;
import com.dyx.ordering.baseseriver.entity.converter.OrderFoodEntityConverter;
import com.dyx.ordering.baseseriver.service.impl.BaseOrderFoodServiceImpl;
import com.dyx.ordering.common.enums.BaseStatus;
import com.dyx.ordering.common.utils.PageUtil;
import com.dyx.ordering.exception.ServiceException;
import com.dyx.ordering.wechat.query.WechatOrderFoodQuery;
import com.dyx.ordering.wechat.service.WechatOrderFoodService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class WechatOrderFoodServiceImpl extends BaseOrderFoodServiceImpl implements WechatOrderFoodService {

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

        return this.saveBatch(orderFoodEntityList);
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

        return this.removeByIds(orderFoodIdList);
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

        boolean updateResult = this.updateById(orderFoodDTO);
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

        return this.updateBatchById(orderFoodEntityList);
    }

    /**
     * 分页查询
     * @param wechatOrderFoodQuery
     * @return
     */
    @Override
    public IPage<OrderFoodDTO> queryPage(WechatOrderFoodQuery wechatOrderFoodQuery) {

        IPage<OrderFoodEntity> orderFoodEntityIPage =
                this.page(PageUtil.buildPage(wechatOrderFoodQuery), buildQueryWrapper(wechatOrderFoodQuery));
        IPage<OrderFoodDTO> orderFoodDTOIPage = OrderFoodEntityConverter.INSTANCE.toIPageDTO(orderFoodEntityIPage);

        expandAttributes(orderFoodDTOIPage.getRecords());

        return orderFoodDTOIPage;
    }

    @Override
    public List<OrderFoodDTO> queryList(WechatOrderFoodQuery orderFoodQuery) {
        List<OrderFoodEntity> orderFoodEntityList = this.list(buildQueryWrapper(orderFoodQuery));

        return OrderFoodEntityConverter.INSTANCE.toDTOList(orderFoodEntityList);
    }

    private LambdaQueryWrapper<OrderFoodEntity> buildQueryWrapper(WechatOrderFoodQuery query){
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
