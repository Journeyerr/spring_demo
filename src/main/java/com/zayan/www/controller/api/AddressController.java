package com.zayan.www.controller.api;


import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.BaseException;
import com.zayan.www.model.entity.Address;
import com.zayan.www.model.entity.Banner;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.form.admin.banner.BannerCreateForm;
import com.zayan.www.model.form.api.AddressCreateForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.AddressService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-04
 */
@RestController
@RequestMapping("/api/address")
public class AddressController extends BaseController {

    @Autowired
    private AddressService addressService;

    @ApiOperation("地址列表")
    @GetMapping("")
    public BaseResult<List<Address>> index() {
        User user = baseUser();
        return BaseResult.success(addressService.addressList(user.getId()));
    }

    @ApiOperation("创建地址")
    @PostMapping("/store")
    public BaseResult<Address> store(@Valid @RequestBody AddressCreateForm createForm) {
        return BaseResult.success(addressService.saveAddress(createForm, baseUser().getId()));
    }

    @ApiOperation("删除地址")
    @PostMapping("/delete/{addressId}")
    public BaseResult<?> delete(@PathVariable("addressId") Integer addressId) {
        User user = baseUser();
        Address address = addressService.getById(addressId);
        if (Objects.isNull(address) || !address.getUserId().equals(user.getId())) {
            throw new BaseException(ErrorEnum.UPDATE_FAIL);
        }
        address.setDeletedAt(LocalDateTime.now());
        addressService.updateById(address);
        return BaseResult.success();
    }
}

