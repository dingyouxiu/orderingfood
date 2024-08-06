package com.dyx.ordering.app.controller;

import com.dyx.ordering.app.service.AppCategoryService;
import com.dyx.ordering.baseseriver.dto.CategoryDTO;
import com.dyx.ordering.baseseriver.dto.FoodDTO;
import com.dyx.ordering.result.Result;
import com.dyx.ordering.wechat.service.WechatCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/category")
@Api(value = "APP端", tags = "菜单分类")
public class AppCategoryController {

    @Autowired
    private AppCategoryService appCategoryService;

    @PostMapping("/save-bath")
    @ApiOperation(value = "新增", notes = "新增")
    public Result<Boolean> saveBath(@RequestBody List<CategoryDTO> categoryDTOList) {
        return Result.success(appCategoryService.saveBath(categoryDTOList));
    }

    @PostMapping("/delete-bath")
    @ApiOperation(value = "删除", notes = "删除")
    public Result<Boolean> deleteBath(@RequestBody List<Long> foodIdList) {
        return Result.success(appCategoryService.deleteBath(foodIdList));
    }

    @PostMapping("/edit")
    @ApiOperation(value = "编辑", notes = "编辑")
    public Result<CategoryDTO> edit(@RequestBody CategoryDTO categoryDTO) {
        return Result.success(appCategoryService.edit(categoryDTO));
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表查询", notes = "列表查询")
    public Result<List<CategoryDTO>> queryList() {
        return Result.success(appCategoryService.queryList());
    }

}
