package com.dyx.ordering.pc.controller;

import com.dyx.ordering.baseseriver.dto.CategoryDTO;
import com.dyx.ordering.pc.service.PcCategoryService;
import com.dyx.ordering.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pc/category")
@Api(value = "PC端", tags = "菜单分类")
public class PcCategoryController {

    @Autowired
    private PcCategoryService appCategoryService;

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
