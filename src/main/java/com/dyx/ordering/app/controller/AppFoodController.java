package com.dyx.ordering.app.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.app.query.AppFoodQuery;
import com.dyx.ordering.app.service.AppFoodService;
import com.dyx.ordering.baseseriver.dto.FoodDTO;
import com.dyx.ordering.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/food")
@Api(value = "PC端", tags = "商品板块")
public class AppFoodController {

    @Autowired
    private AppFoodService wechatFoodService;

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
    public Result<IPage<FoodDTO>> queryPage(AppFoodQuery foodQuery) {
        return Result.success(wechatFoodService.queryPage(foodQuery));
    }

}
