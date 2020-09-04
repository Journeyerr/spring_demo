package com.zayan.www.controller.api;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.banner.BannerVO;
import com.zayan.www.service.BannerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-01
 */
@RestController
@RequestMapping("/api/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @ApiOperation("Banner列表")
    @GetMapping("")
    public BaseResult<IPage<BannerVO>> store(@RequestParam("shopId") Integer shopId,
                                             @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                             @RequestParam(value = "page", required = false) Integer page){

        return BaseResult.success(bannerService.listRecord(shopId, 1, page, pageSize));
    }
}

