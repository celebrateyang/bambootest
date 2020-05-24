package com.bamboo.filter;/**
 * Created by zhuqyang on 2020/5/22.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyAuthenticationFilter
 * @Description MyAuthenticationFilter
 * @Author zhuqyang
 * @Date 2020/5/22 11:29
 * @Version 1.0
 */
public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        System.out.println("MyAuthenticationFilter username==>"+username);
        //这个构造函数,会将isAuthenticated设置为false,所以这里可以直接用.我们会在定制的MyProvider进行真正的认证流程.
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, "");
        authRequest.setDetails("detailsss");
        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return super.getAuthenticationManager().authenticate(authRequest);
    }
    public void setAuthenticationManager(AuthenticationManager authenticationManager){
        super.setAuthenticationManager(authenticationManager);
//        this.authenticationManager = authenticationManager;
    }

}
