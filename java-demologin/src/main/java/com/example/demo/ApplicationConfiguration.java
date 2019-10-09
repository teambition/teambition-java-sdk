package com.example.demo;


import com.alibaba.teambition.sdk.filter.SSOFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    FilterRegistrationBean registerSessionFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new SSOFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("appId", "5d83377eb013170001388c8c");
        registrationBean.addInitParameter("appSecret", "N6WfzlMBOdIKTnoUaLFVaDoV9CGM087a");
        registrationBean.addInitParameter("apiHost", "https://www.teambitionapis.com/tbs");
        registrationBean.addInitParameter("oauthHost", "https://account.teambition.com");
        registrationBean.addInitParameter("excludes", "/health.check");
        registrationBean.addInitParameter("ssoCallback", "com.example.demo.DemoSSOCallback");

        registrationBean.setOrder(0);
        return registrationBean;
    }
}
