package com.example.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.teambition.sdk.apis.UserApi;
import com.alibaba.teambition.sdk.auth.AuthContext;
import com.alibaba.teambition.sdk.filter.SSOCallback;
import com.alibaba.teambition.sdk.model.User;
import com.alibaba.teambition.sdk.user.UserService;

public class DemoSSOCallback extends SSOCallback {

    /**
     * 登陆前处理
     *
     * @param request
     * @param response
     */
    @Override
    public void beforeLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * 登陆后处理
     *
     * @param request
     * @param response
     */
    @Override
    public void afterLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.afterLogin(request, response);
    }


    /**
     * 登陆成功后， 自行处理用户
     *
     * @param user
     */
    @Override
    public void handleUser(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = user.getId();
        String openId = user.getOpenId();

        User tmpUser = UserService.getUserById(userId);
        User tmpUser2 = AuthContext.getApiClient(UserApi.class).getUserByOpenId(openId);
    }



    /**
     * 登陆失败时的回调
     *
     * @param request
     * @param response
     * @param isAjaxRequest 是否ajax请求
     * @param errJson 出错信息
     * @return true： 已处理;  false: 未处理
     */
    @Override
    public Boolean handleInvalidSession(HttpServletRequest request, HttpServletResponse response, Boolean isAjaxRequest, String errJson) throws ServletException, IOException{
        if (isAjaxRequest) {
            response.getWriter().write(errJson);
        } else {
            response.getWriter().write("<h1>should login</h1>");
        }
        return true;
    }
}

