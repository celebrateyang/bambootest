package com.bamboo.Handler;/**
 * Created by zhuqyang on 2020/5/27.
 */

import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * @ClassName MySuccessHandler
 * @Description MySuccessHandler
 * @Author zhuqyang
 * @Date 2020/5/27 22:14
 * @Version 1.0
 */
public class MySuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    public MySuccessHandler(){
        this.setDefaultTargetUrl("/home");
       // this.setAlwaysUseDefaultTargetUrl(true);
    }
}
