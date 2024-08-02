package com.dyx.ordering.wechat.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dyx.ordering.baseseriver.dto.FoodDTO;
import com.dyx.ordering.result.Result;
import com.dyx.ordering.wechat.query.WechatFoodQuery;
import com.dyx.ordering.wechat.service.WechatFoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wechat/food")
@Api(value = "小程序", tags = "商品板块")
public class FoodController {

    @Autowired
    private WechatFoodService wechatFoodService;

    @GetMapping("/page")
    @ApiOperation(value = "分页查询", notes = "分页查询")
    public Result<IPage<FoodDTO>> queryPage(WechatFoodQuery foodQuery) {
        return Result.success(wechatFoodService.queryPage(foodQuery));
    }

}
