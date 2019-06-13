package cn.org.szdaxh.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>Title: //TODO </p>
 * <p>Description: //TODO </p>
 * <p>Copyright: Copyright (c) 2012 版权</p>
 * <p>Company:dingfu </p>
 *
 * @author zhangshuai
 * @version V2.1
 * @Datetime 2019/6/13
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public BasePathInterceptor basePathInterceptor() {
        return new BasePathInterceptor();
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(basePathInterceptor())
               .addPathPatterns("/**");

       registry.addInterceptor(loginInterceptor())
               .addPathPatterns("/admin/**")
               .excludePathPatterns("/admin/login");
    }
}
