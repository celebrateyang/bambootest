package com.bamboo.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @ClassName HandleExceptionControllerAdvice
 * @Description HandleExceptionControllerAdvice
 * @Author zhuqyang
 * @Date 2020/5/30 21:50
 * @Version 1.0
 *如果springmvc配置文件中<mvc:annotation-driven/>没有打开的话,这里需要加上@EnableWebMvc
 */
//@EnableWebMvc
@ControllerAdvice
public class HandleExceptionControllerAdvice {
    public HandleExceptionControllerAdvice(){
        System.out.println("==================================================");
    }

    @ExceptionHandler(Exception.class)
    public String handleAllException(Exception e, Model model){
        model.addAttribute("errormessage",e.getMessage());
        return "403";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDenied(Exception e, Model model){
        model.addAttribute("errormessage","advice");
        return "403";
    }


}

