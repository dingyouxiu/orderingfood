package com.dyx.ordering.wechat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dyx.ordering.basedao.dto.OrderDTO;
import com.dyx.ordering.basedao.dto.OrderFoodDTO;
import com.dyx.ordering.basedao.entity.OrderEntity;
import com.dyx.ordering.basedao.entity.converter.OrderEntityConverter;
import com.dyx.ordering.basedao.dao.BaseOrderIDao;
import com.dyx.ordering.common.constant.BaseConstants;
import com.dyx.ordering.common.enums.BaseStatus;
import com.dyx.ordering.common.enums.OrderStatus;
import com.dyx.ordering.common.utils.PageUtil;
import com.dyx.ordering.exception.ServiceException;
import com.dyx.ordering.wechat.mapper.WechatOrderMapper;
import com.dyx.ordering.wechat.query.WechatOrderFoodQuery;
import com.dyx.ordering.wechat.query.WechatOrderQuery;
import com.dyx.ordering.wechat.service.WechatOrderFoodService;
import com.dyx.ordering.wechat.service.WechatOrderService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Service
public class WechatOrderServiceImpl implements WechatOrderService {
    private final ReentrantLock reentrantLock = new ReentrantLock();

    @Autowired
    private BaseOrderIDao baseOrderIDao;

    @Autowired
    private WechatOrderFoodService wechatOrderFoodService;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private WechatOrderMapper wechatOrderMapper;

    /**
     * 新增
     * @param orderDTOList
     * @return
     */
    @Override
    @Transactional
    public Boolean saveBath(List<OrderDTO> orderDTOList) {
        if (CollectionUtils.isEmpty(orderDTOList)) {
            return Boolean.FALSE;
        }

        List<OrderEntity> orderEntityList = OrderEntityConverter.INSTANCE.toEntityList(orderDTOList);

        return baseOrderIDao.saveBatch(orderEntityList);
    }

    /**
     * 删除-批量
     * @param orderIdList
     * @return
     */
    @Override
    @Transactional
    public Boolean deleteBath(List<Long> orderIdList) {
        if (CollectionUtils.isEmpty(orderIdList)) {
            return Boolean.FALSE;
        }

        return baseOrderIDao.removeByIds(orderIdList);
    }

    /**
     * 编辑
     * @param orderDTO
     * @return
     */
    @Override
    @Transactional
    public Boolean edit(OrderDTO orderDTO) {
        if (Objects.isNull(orderDTO)) {
            return Boolean.FALSE;
        }

        return baseOrderIDao.updateById(orderDTO);
    }

    /**
     * 分页查询
     * @param orderQuery
     * @return
     */
    @Override
    public IPage<OrderDTO> queryPage(WechatOrderQuery orderQuery) {

        IPage<OrderEntity> orderEntityIPage =
                baseOrderIDao.page(PageUtil.buildPage(orderQuery), buildQueryWrapper(orderQuery));
        IPage<OrderDTO> orderDTOIPage = OrderEntityConverter.INSTANCE.toIPageDTO(orderEntityIPage);
        expandAttributes(orderDTOIPage.getRecords());

        return orderDTOIPage;
    }

    @Override
    @Transactional
    public OrderDTO addOns(OrderDTO orderDTO) {
        if (Objects.isNull(orderDTO)) {
            throw new ServiceException(BaseStatus.PARAMETER_MISS);
        }

        // 新增订单
        if (Objects.isNull(orderDTO.getId())) {
            addOnsNewOrder(orderDTO);
        }

        // 修改订单
        if (Objects.nonNull(orderDTO.getId())) {
            addOnsUpdateOrder(orderDTO);
        }

        return orderDTO;
    }

    /**
     * 订单新增
     * @param orderDTO
     */
    private void addOnsNewOrder(OrderDTO orderDTO){

        // 保存订单商品
        List<OrderFoodDTO> orderFoodDTOList = orderDTO.getOrderFoodDTOList();

        // 计算价格
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (OrderFoodDTO orderFoodDTO : orderFoodDTOList) {
            BigDecimal foodPrice = orderFoodDTO.getPrice();
            BigDecimal discount = orderFoodDTO.getDiscount();
            BigDecimal num = BigDecimal.valueOf(orderFoodDTO.getNum());
            BigDecimal realityPrice = foodPrice.multiply(discount).multiply(num);
            totalPrice = totalPrice.add(realityPrice);
        }
        Boolean saveOrderFoodList = wechatOrderFoodService.saveBath(orderFoodDTOList);

        // 保存订单
        OrderEntity orderEntity = OrderEntityConverter.INSTANCE.toEntity(orderDTO);
        orderEntity.setTotalPrice(totalPrice);
        boolean saveOrder = baseOrderIDao.save(orderEntity);

        if (!(saveOrder && saveOrderFoodList)) {
            throw new ServiceException(BaseStatus.ORDER_SAVE_ERROR);
        }

    }

    /**
     * 订单编辑
     * @param orderDTO
     */
    private void addOnsUpdateOrder(OrderDTO orderDTO){

        // 查询订单中已存在商品
        WechatOrderFoodQuery wechatOrderFoodQuery =
                WechatOrderFoodQuery.builder()
                        .orderId(orderDTO.getId())
                        .build();

        // 保存订单商品
        List<OrderFoodDTO> orderFoodDTOList = orderDTO.getOrderFoodDTOList();
        // 新增商品
        List<OrderFoodDTO> newOrderFoodDTOList =
                orderFoodDTOList
                        .stream()
                        .filter(orderFoodDTO -> Objects.isNull(orderFoodDTO.getId()))
                        .collect(Collectors.toList());
        Boolean saveOrderFoodResult = wechatOrderFoodService.saveBath(newOrderFoodDTOList);

        // 修改商品
        List<OrderFoodDTO> updateOrderFoodDTOList =
                orderFoodDTOList
                        .stream()
                        .filter(orderFoodDTO -> Objects.nonNull(orderFoodDTO.getId()))
                        .collect(Collectors.toList());
        Boolean updateOrderFoodResult = wechatOrderFoodService.editBath(updateOrderFoodDTOList);

        // 计算价格
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (OrderFoodDTO orderFoodDTO : orderFoodDTOList) {
            BigDecimal foodPrice = orderFoodDTO.getPrice();
            BigDecimal discount = orderFoodDTO.getDiscount();
            BigDecimal num = BigDecimal.valueOf(orderFoodDTO.getNum());
            BigDecimal realityPrice = foodPrice.multiply(discount).multiply(num);
            totalPrice = totalPrice.add(realityPrice);
        }

        // 更新订单
        OrderEntity orderEntity = OrderEntityConverter.INSTANCE.toEntity(orderDTO);
        orderEntity.setTotalPrice(totalPrice);
        boolean updateOrderResult = baseOrderIDao.updateById(orderEntity);

        if (!(updateOrderResult && saveOrderFoodResult && updateOrderFoodResult)) {
            throw new ServiceException(BaseStatus.ORDER_SAVE_ERROR);
        }

    }

    /**
     * 下单
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO purchase(OrderDTO orderDTO) {
        if (Objects.isNull(orderDTO)) {
            throw new ServiceException(BaseStatus.PARAMETER_MISS);
        }

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("purchaseTransaction");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);

        OrderEntity orderEntity = OrderEntityConverter.INSTANCE.toEntity(orderDTO);
        orderEntity.setState(OrderStatus.NOT_APPRAISE.getCode());

        // 解决并发流水码重复问题
        int retryNum = 0;
        do {
            if (reentrantLock.tryLock()) {
                try {
                    // 生成流水码
                    Long serialNumberMax = wechatOrderMapper.selectSerialNumberMax();
                    orderEntity.setSerialNumber(++serialNumberMax);

                    boolean updateOrderResult = baseOrderIDao.updateById(orderDTO);
                    if (!updateOrderResult) {
                        throw new ServiceException(BaseStatus.ORDER_PURCHASE_ERROR);
                    }

                    // 手动提交事务
                    transactionManager.commit(status);
                    break;
                }catch (Exception exception){
                    transactionManager.rollback(status);
                    throw new ServiceException(BaseStatus.ORDER_PURCHASE_ERROR);
                }finally {
                    reentrantLock.unlock();
                }
            }
        }while (++retryNum <= BaseConstants.RETRY_NUMBER);

        if (retryNum > BaseConstants.RETRY_NUMBER) {
            transactionManager.rollback(status);
            throw new ServiceException(BaseStatus.ORDER_PURCHASE_ERROR);
        }

        return orderDTO;
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

    @Override
    public BaseOrderIDao getBaseIDao() {
        return this.baseOrderIDao;
    }
}
