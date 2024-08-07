package com.dyx.ordering.pc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.basedao.dto.OrderDTO;
import com.dyx.ordering.pc.query.PcOrderQuery;
import com.dyx.ordering.pc.service.PcOrderService;
import com.dyx.ordering.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pc/order")
@Api(value = "PC端", tags = "订单板块")
public class PcOrderController {

    @Autowired
    private PcOrderService wechatOrderService;

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
    public Result<IPage<OrderDTO>> queryPage(PcOrderQuery orderQuery) {
        return Result.success(wechatOrderService.queryPage(orderQuery));
    }

    @PostMapping("/add-ons")
    @ApiOperation(value = "加购", notes = "加购")
    public Result<OrderDTO> addOns(@RequestBody OrderDTO orderDTO) {
        return Result.success(wechatOrderService.addOns(orderDTO));
    }

    @PostMapping("/purchase")
    @ApiOperation(value = "购买", notes = "购买")
    public Result<OrderDTO> purchase(@RequestBody OrderDTO orderDTO) {
        return Result.success(wechatOrderService.purchase(orderDTO));
    }

}
