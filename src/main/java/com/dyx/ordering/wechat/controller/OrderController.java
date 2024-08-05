package com.dyx.ordering.wechat.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.baseseriver.dto.OrderDTO;
import com.dyx.ordering.result.Result;
import com.dyx.ordering.wechat.query.WechatOrderQuery;
import com.dyx.ordering.wechat.service.WechatOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wechat/order")
@Api(value = "小程序", tags = "订单板块")
public class OrderController {

    @Autowired
    private WechatOrderService wechatOrderService;

    @PostMapping("/save-bath")
    @ApiOperation(value = "新增", notes = "新增")
    public Result<Boolean> saveBath(@RequestBody List<OrderDTO> orderDTOList) {
        return Result.success(wechatOrderService.saveBath(orderDTOList));
    }

    @PostMapping("/delete-bath")
    @ApiOperation(value = "删除", notes = "删除")
    public Result<Boolean> deleteBath(@RequestBody List<Long> orderIdList) {
        return Result.success(wechatOrderService.deleteBath(orderIdList));
    }

    @PostMapping("/edit")
    @ApiOperation(value = "编辑", notes = "编辑")
    public Result<Boolean> edit(@RequestBody OrderDTO orderDTO) {
        return Result.success(wechatOrderService.edit(orderDTO));
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询", notes = "分页查询")
    public Result<IPage<OrderDTO>> queryPage(WechatOrderQuery orderQuery) {
        return Result.success(wechatOrderService.queryPage(orderQuery));
    }

    @PostMapping("/add-ons")
    @ApiOperation(value = "加购", notes = "加购")
    public Result<OrderDTO> addOns(@RequestBody OrderDTO orderDTO) {
        return Result.success(wechatOrderService.addOns(orderDTO));
    }

}
