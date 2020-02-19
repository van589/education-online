package com.van589.mooc.web.admin.configure;

import com.van589.mooc.web.admin.web.interceptor.LoginInterceptor;
import com.van589.mooc.web.admin.web.interceptor.PermissionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Web 配置
 */
@Configuration
public class WebConfigure  implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private PermissionInterceptor permissionInterceptor;

    /**
     * 注册 Interceptor
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/static/**");
        registry.addInterceptor(permissionInterceptor)
                .addPathPatterns("/**");
    }

}
