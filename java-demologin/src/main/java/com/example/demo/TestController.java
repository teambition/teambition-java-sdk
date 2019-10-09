package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.teambition.sdk.apis.UserApi;
import com.alibaba.teambition.sdk.auth.AuthContext;
import com.alibaba.teambition.sdk.model.User;
import com.alibaba.teambition.sdk.user.UserService;

@RestController
public class TestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public void hello() {
        String appId = "5d83377eb013170001388c8c";
        String appSecret = "N6WfzlMBOdIKTnoUaLFVaDoV9CGM087a";

        String apiHost = "https://www.teambitionapis.com/tbs";
        AuthContext.setAppId(appId);
        AuthContext.setAppSecret(appSecret);
        AuthContext.setApiHost(apiHost);
        AuthContext.getContext().setTenantId("*");
        AuthContext.getContext().setTenantType("organization");

        String userId = "029201112";
        User user = AuthContext.getApiClient(UserApi.class).getUserByOpenId(userId);
    }

}
