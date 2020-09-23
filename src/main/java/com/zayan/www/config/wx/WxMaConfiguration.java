package com.zayan.www.config.wx;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.zayan.www.constant.common.wx.WeiXin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author AnYuan
 */

@Configuration
public class WxMaConfiguration {

    @Bean
    public WxMaService wxMaService() {
        WxMaServiceImpl wxMaService = new WxMaServiceImpl();
        WxMaDefaultConfigImpl wxMaDefaultConfig = new WxMaDefaultConfigImpl();
        wxMaDefaultConfig.setAppid(WeiXin.APP_ID);
        wxMaDefaultConfig.setSecret(WeiXin.APP_SECRET);
        wxMaService.setWxMaConfig(wxMaDefaultConfig);
        return wxMaService;
    }
}
