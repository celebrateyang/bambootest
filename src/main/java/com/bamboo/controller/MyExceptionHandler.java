package com.bamboo.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyExceptionHandler
 * @Description MyExceptionHandler
 * @Author zhuqyang
 * @Date 2020/6/1 13:12
 * @Version 1.0
 */
//@Component
public class MyExceptionHandler implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if(e instanceof AccessDeniedException){
            modelAndView.addObject("errormessage",e.getMessage());
        }
        modelAndView.setViewName("403");
        return modelAndView;
    }
}
