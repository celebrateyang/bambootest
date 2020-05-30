package com.bamboo.Handler;/**
 * Created by zhuqyang on 2020/5/28.
 */

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * @ClassName MyFailureHandler
 * @Description MyFailureHandler
 * @Author zhuqyang
 * @Date 2020/5/28 10:22
 * @Version 1.0
 */
public class MyFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    public MyFailureHandler(){
        this.setDefaultFailureUrl("/login");
    }
}
