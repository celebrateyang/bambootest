package com.bamboo.controller;/**
 * Created by zhuqyang on 2020/5/20.
 */

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "home", method = {RequestMethod.GET})
    public String index() {
        return "index";
    }

    @Secured("ROLE_PRODUCT")
    @RequestMapping(value = "product",method = RequestMethod.GET)
    public String product(){
        return "product";
    }

    @RequestMapping(value = "processLogin",method = {RequestMethod.POST,RequestMethod.GET})
    public String pressLogin(){
        return "process";
    }

}
