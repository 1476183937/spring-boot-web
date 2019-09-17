package com.atguigu.springbootweb.config;

import com.atguigu.springbootweb.SpringBootWebApplication;
import com.atguigu.springbootweb.cpmponent.LoginHandlerIterceptor;
import com.atguigu.springbootweb.cpmponent.MyLocaleResolver;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/atguigu").setViewName("success");
        registry.addViewController("/").setViewName("index");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //添加拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        //.addPathPatterns("/**").中设置拦截所有时不会拦截静态资源，springboot已经做好了静态资源映射
        registry.addInterceptor(new LoginHandlerIterceptor()).addPathPatterns("/**").
                excludePathPatterns("index.html","/","/usr/login","/asserts/css**","/asserts/js**");
    }

    //所有的WebMvcConfigurationSupport组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurationSupport webMvcConfigurerAdapter(){
//        WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter adapter = new WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/index.html").setViewName("login");
//                registry.addViewController("main.html").setViewName("dashboard");
//            }
//        };
        WebMvcConfigurationSupport adapter = new WebMvcConfigurationSupport(){
            @Override
            protected void addViewControllers(ViewControllerRegistry registry) {
                //super.addViewControllers(registry);
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("main.html").setViewName("dashboard");
            }
        };
        return adapter;
    }
}
