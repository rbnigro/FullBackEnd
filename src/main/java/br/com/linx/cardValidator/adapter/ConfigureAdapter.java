package br.com.linx.cardValidator.adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

@Configuration
public class ConfigureAdapter implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver argumentResolver = new PageableHandlerMethodArgumentResolver();

      //  Sort sort = new Sort(Sort.DEFAULT_DIRECTION, Sort.unsorted());

        argumentResolver.setOneIndexedParameters(true);
       // argumentResolver.setFallbackPageable(new PageRequest(0, 1, sort));
        argumentResolvers.add(argumentResolver);
        WebMvcConfigurer.super.addArgumentResolvers(argumentResolvers);
    }
}
