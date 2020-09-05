package com.zayan.www.controller.api;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.google.common.collect.Maps;
import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.BaseException;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.form.api.UserUpdateInfoForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.user.UserVO;
import com.zayan.www.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author AnYuan
 */

@Slf4j
@Api(tags = "用户APi")
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private WxMaService wxMaService;

    @ApiOperation("微信登录")
    @GetMapping("/wx/login")
    public BaseResult<?> wxLogin(@RequestParam("code") String code){
        try {
            WxMaJscode2SessionResult result = wxMaService.jsCode2SessionInfo(code);
            Map<String, String> userMap = Maps.newHashMapWithExpectedSize(1);
            userMap.put("token", userService.wxLoginGetToken(result.getOpenid(), result.getSessionKey()));
            return BaseResult.success(userMap);
        }catch (WxErrorException e){
            log.info("Wx_Login_Exception:{}", e.getMessage());
            throw new BaseException(ErrorEnum.SERVICE_ERROR);
        }
    }

    @ApiOperation("用户信息")
    @GetMapping("")
    public BaseResult<UserVO> show(){
        User user = baseUser();
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return BaseResult.success(userVO);
    }


    @ApiOperation("微信后去用户信息更新")
    @PostMapping("/update")
    public BaseResult<UserVO> updateUserInfo(@RequestBody UserUpdateInfoForm infoForm){
        User user = baseUser();

        user.setName(infoForm.getNickName());
        user.setImageUrl(infoForm.getAvatarUrl());
        user.setSex(UserUpdateInfoForm.coverGender(infoForm.getGender()));
        user.setCountry(infoForm.getCountry());
        user.setProvince(infoForm.getProvince());
        user.setCity(infoForm.getCity());

        userService.updateById(user);

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);

        return BaseResult.success(userVO);
    }
}
