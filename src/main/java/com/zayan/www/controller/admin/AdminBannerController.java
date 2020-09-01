package com.zayan.www.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.BaseException;
import com.zayan.www.model.entity.Banner;
import com.zayan.www.model.entity.Product;
import com.zayan.www.model.form.admin.banner.BannerCreateForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.admin.BannerVO;
import com.zayan.www.service.BannerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-01
 */
@RestController
@RequestMapping("/admin/banner")
public class AdminBannerController {

    @Autowired
    private BannerService bannerService;

    @ApiOperation("Banner列表")
    @GetMapping("/index")
    public BaseResult<IPage<BannerVO>> store(@RequestParam(value = "shopId", required = false) Integer shopId,
                                             @RequestParam("pageSize") Integer pageSize,
                                             @RequestParam("page") Integer page){

        return BaseResult.success(bannerService.listRecord(shopId, 1, page, pageSize));
    }

    @ApiOperation("创建Banner")
    @PostMapping("/store")
    public BaseResult<Banner> store(@RequestBody BannerCreateForm createForm){

        Banner banner = new Banner();
        banner.setImageId(createForm.getImageId());
        banner.setShopId(createForm.getShopId());
        banner.setStatus(createForm.getStatus());
        bannerService.save(banner);
        return BaseResult.success(banner);
    }

    @ApiOperation("删除banner")
    @PostMapping("/delete/{bannerId}")
    public BaseResult<?> delete(@PathVariable("bannerId") Integer bannerId){
        Banner banner = bannerService.getById(bannerId);
        if (Objects.isNull(banner)) {
            throw new BaseException(ErrorEnum.UPDATE_FAIL);
        }
        banner.setDeletedAt(LocalDateTime.now());
        bannerService.updateById(banner);
        return BaseResult.success();
    }

    @ApiOperation("更新banner状态")
    @PostMapping("/update/{bannerId}")
    public BaseResult<?> update(@PathVariable("bannerId") Integer bannerId){
        Banner banner = bannerService.getById(bannerId);
        if (Objects.isNull(banner)) {
            throw new BaseException(ErrorEnum.UPDATE_FAIL);
        }
        banner.setStatus(banner.getStatus().equals(1) ? 0 : 1);
        bannerService.updateById(banner);
        return BaseResult.success();
    }
}

