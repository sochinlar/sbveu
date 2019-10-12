package com.sbveu.demo.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.sbveu.demo.conpoment.PageArgumentResolver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author NieYinjun
 * @date 2019/10/12 14:15
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    //////////////////////////////////////////分页相关  start///////////////////////////
    /**
     * 分页插件：启用分页功能
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new PageArgumentResolver());
    }
    @Bean
    @ConditionalOnMissingBean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    //////////////////////////////////////////分页相关  end///////////////////////////

    //////////////////////////////////////////静态资源相关 start///////////////////////////

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/static/**")//访问的路径
        //        .addResourceLocations("classpath:/static/"); //映射到路径

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/test/test.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    //////////////////////////////////////////静态资源相关  end///////////////////////////

    //////////////////////////////////////////JSON序列化使用fastjson  start///////////////////////////
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.removeAll(converters.stream().filter(e -> e instanceof MappingJackson2HttpMessageConverter).collect(Collectors.toList()));
        converters.add(fastJsonHttpMessageConverter());
        System.out.println(converters);
    }

    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteDateUseDateFormat);
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(BigInteger.class, com.alibaba.fastjson.serializer.ToStringSerializer.instance);
        serializeConfig.put(Long.class, com.alibaba.fastjson.serializer.ToStringSerializer.instance);
        serializeConfig.put(Long.TYPE, com.alibaba.fastjson.serializer.ToStringSerializer.instance);
        config.setSerializeConfig(serializeConfig);
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");

        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.ALL);

        converter.setSupportedMediaTypes(supportedMediaTypes);
        converter.setFastJsonConfig(config);
        return converter;
    }
    //////////////////////////////////////////JSON序列化使用fastjson  end///////////////////////////


}
