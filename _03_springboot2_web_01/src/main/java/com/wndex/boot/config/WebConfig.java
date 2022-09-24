package com.wndex.boot.config;

import com.wndex.boot.bean.Pet;
import com.wndex.boot.converter.WndexMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.List;

/**
 * @author wndexx 2022-09-16 19:42
 */
@Configuration
public class WebConfig /*implements WebMvcConfigurer*/ {
    // 手动注册 HiddenHttpMethodFilter 组件
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("_m");
        return hiddenHttpMethodFilter;
    }

    @Bean // WebMvcConfigurer
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                // 设置为不移除分号后面的内容，矩阵变量功能就可以生效
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            @Override
            public void addFormatters(FormatterRegistry registry) {
                // 添加转换器
                // Converter<String, Pet> 指明接口类型
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        if ("".equals(source)) {
                            System.out.println(true);
                        }
                        // StringUtils：Spring 提供的 String 的工具类
                        // tom&2
                        if (StringUtils.isEmpty(source)) {
                            return null;
                        }

                        // String[] split = StringUtils.split(source, "&");
                        String[] split = source.split("&");
                        return new Pet(split[0], Integer.parseInt(split[1]));
                    }
                });
            }

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                configurer.parameterName("ll");
                configurer.mediaType("xyz", MediaType.parseMediaType("application/x-wndex;charset=itf-8"));
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new WndexMessageConverter());
            }
        };
    }
    // @Override
    // public void configurePathMatch(PathMatchConfigurer configurer) {
    //     UrlPathHelper urlPathHelper = new UrlPathHelper();
    //     // 设置为不移除分号后面的内容，矩阵变量功能就可以生效
    //     urlPathHelper.setRemoveSemicolonContent(false);
    //     configurer.setUrlPathHelper(urlPathHelper);
    // }
}
