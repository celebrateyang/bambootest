package com.bamboo.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName HandleExceptionControllerAdvice
 * @Description HandleExceptionControllerAdvice
 * @Author zhuqyang
 * @Date 2020/5/30 21:50
 * @Version 1.0
 */
@ControllerAdvice
public class HandleExceptionControllerAdvice {
    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDenied(){
        return "403";
    }
}

