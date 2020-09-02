package com.zayan.www.controller.api;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.google.common.collect.Maps;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.form.api.UserLoginForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.user.UserVO;
import com.zayan.www.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author AnYuan
 */

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
            Map<String, String> userMap = Maps.newHashMap();
            userMap.put("token", userService.wxLoginGetToken(result.getOpenid(), result.getSessionKey()));
            return BaseResult.success(userMap);
        }catch (WxErrorException e){
            return BaseResult.error(e.getMessage());
        }
    }

    @ApiOperation("用户信息")
    @GetMapping("")
    public BaseResult<UserVO> show(){
        User user = baseUser();
        UserVO userVO = UserVO.builder().id(user.getId())
                .userName(user.getName())
                .phone(user.getPhone())
                .imageUrl(user.getImageUrl())
                .build();
        return BaseResult.success(userVO);
    }
}
