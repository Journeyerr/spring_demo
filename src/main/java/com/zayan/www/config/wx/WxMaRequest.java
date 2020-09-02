package com.zayan.www.config.wx;

import cn.binarywang.wx.miniapp.api.impl.BaseWxMaServiceImpl;
import me.chanjar.weixin.common.util.http.HttpType;

import java.io.IOException;

public class WxMaRequest extends BaseWxMaServiceImpl {
    @Override
    protected String doGetAccessTokenRequest() throws IOException {
        return null;
    }

    @Override
    public void initHttp() {

    }

    @Override
    public Object getRequestHttpClient() {
        return null;
    }

    @Override
    public Object getRequestHttpProxy() {
        return null;
    }

    @Override
    public HttpType getRequestType() {
        return null;
    }
}
