package com.dyx.ordering.wechat.controller;

import com.dyx.ordering.basedao.dto.CategoryDTO;
import com.dyx.ordering.result.Result;
import com.dyx.ordering.wechat.service.WechatCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wechat/category")
@Api(value = "小程序", tags = "菜单分类")
public class WechatCategoryController {

    @Autowired
    private WechatCategoryService wechatCategoryService;

    @GetMapping("/list")
    @ApiOperation(value = "列表查询", notes = "列表查询")
    public Result<List<CategoryDTO>> queryList() {
        return Result.success(wechatCategoryService.queryList());
    }

}
