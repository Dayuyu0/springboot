package com.lagou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration//标注该类为配置类
public class MyLocaleResolver implements LocaleResolver {
    //自定义区域配置解析类
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取页面手动传递的语言参数
        String l = httpServletRequest.getParameter("l");
        //获取请求头自动传递的语言参数Accept-Language
        String header = httpServletRequest.getHeader("Accept-Language");
        Locale locale = null;
        //如果手动切换参数不为空，就根据手动参数进行语言切换，否则默认根据请求头信息切换
        if(!StringUtils.isEmpty(l)){
            //zh_CN  en_US 根据_切割字符串
            String[] split = l.split("_");
            //设置local
            locale = new Locale(split[0],split[1]);
        }else{
            //如果为空
            // Accept-Language: en-US,en;q=0.9
            String[] split1 = header.split(",");
            String[] split = split1[0].split("-");
            locale = new Locale(split[0],split[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }

    //将自定义的MyLocaleResolver类重新注册为一个类型LocaleResolver的bean组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
