package com.yang.springbootfilterinterceptor.config;

import com.yang.springbootfilterinterceptor.interceptor.StatusCheckInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class StatusCheckInterceptorConfig extends WebMvcConfigurationSupport {

    /**
     * 1.提供拦截器的实例化方法，解决拦截器所依赖bean为空的问题
     * 2.拦截器实现类的Component注解不是必须的
     *
     * @return
     */
    @Bean
    public StatusCheckInterceptor statusCheckInterceptor() {
        return new StatusCheckInterceptor();
    }

    /**
     * 1.提供拦截器的实例化方法，解决拦截器所依赖bean为空的问题
     * 2.而不能简单的直接new出拦截器实例，必须调用上面的方法才行
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(statusCheckInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login");
        super.addInterceptors(registry);
    }

}
