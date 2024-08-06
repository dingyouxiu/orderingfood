package com.dyx.ordering.wechat.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.baseseriver.dto.FoodDTO;
import com.dyx.ordering.result.Result;
import com.dyx.ordering.wechat.query.WechatFoodQuery;
import com.dyx.ordering.wechat.service.WechatFoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wechat/food")
@Api(value = "小程序", tags = "商品板块")
public class WechatFoodController {

    @Autowired
    private WechatFoodService wechatFoodService;

    @PostMapping("/save-bath")
    @ApiOperation(value = "新增", notes = "新增")
    public Result<Boolean> saveBath(@RequestBody List<FoodDTO> foodDTOList) {
        return Result.success(wechatFoodService.saveBath(foodDTOList));
    }

    @PostMapping("/delete-bath")
    @ApiOperation(value = "删除", notes = "删除")
    public Result<Boolean> deleteBath(@RequestBody List<Long> foodIdList) {
        return Result.success(wechatFoodService.deleteBath(foodIdList));
    }

    @PostMapping("/edit")
    @ApiOperation(value = "编辑", notes = "编辑")
    public Result<FoodDTO> edit(@RequestBody FoodDTO foodDTO) {
        return Result.success(wechatFoodService.edit(foodDTO));
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询", notes = "分页查询")
    public Result<IPage<FoodDTO>> queryPage(WechatFoodQuery foodQuery) {
        return Result.success(wechatFoodService.queryPage(foodQuery));
    }

}
