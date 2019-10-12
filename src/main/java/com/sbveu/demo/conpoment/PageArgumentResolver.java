package com.sbveu.demo.conpoment;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.core.MethodParameter;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Objects;

/**
 * 分页设置:自定义分页参数名称
 * @author ydx
 */
public class PageArgumentResolver implements HandlerMethodArgumentResolver {
    //分页参数名称
    private static final String PAGE_SIZE_NAME = "pageSize";
    private static final String PAGE_NO_NAME = "pageNo";

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(IPage.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
            ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) {
        String page = Objects.toString(nativeWebRequest.getParameter(PAGE_NO_NAME), "1");
        String size = Objects.toString(nativeWebRequest.getParameter(PAGE_SIZE_NAME), "10");
        int pageNumber = NumberUtils.parseNumber(page, Integer.class);
        int pageSize = NumberUtils.parseNumber(size, Integer.class);
        return new Page<>(pageNumber, pageSize);
    }
}
