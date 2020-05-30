package com.bamboo.filter;/**
 * Created by zhuqyang on 2020/5/22.
 */

import com.bamboo.Handler.MyFailureHandler;
import com.bamboo.Handler.MySuccessHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyAuthenticationFilter
 * @Description MyAuthenticationFilter
 * @Author zhuqyang
 * @Date 2020/5/22 11:29
 * @Version 1.0
 */
public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public MyAuthenticationFilter(){
        RequestMatcher requiresAuthenticationRequestMatcher = new AntPathRequestMatcher("/processLogin", "POST");
        this.setRequiresAuthenticationRequestMatcher(requiresAuthenticationRequestMatcher);
        MySuccessHandler mySuccessHandler = new MySuccessHandler();
        this.setAuthenticationSuccessHandler(mySuccessHandler);
        MyFailureHandler myFailureHandler = new MyFailureHandler();
        this.setAuthenticationFailureHandler(myFailureHandler);
       // super((new AntPathRequestMatcher("/processLogin", "POST")));
//        super.setFilterProcessesUrl("/processLogin");
       /* this.setAuthenticationSuccessHandler(new ForwardAuthenticationSuccessHandler("/product"));*/
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        System.out.println("MyAuthenticationFilter username==>" + username);
        //这个构造函数,会将isAuthenticated设置为false,所以这里可以直接用.我们会在定制的MyProvider进行真正的认证流程.
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, "");
        authRequest.setDetails("detailsss");
        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);
        if("user2".equals(username)) {
            throw new BadCredentialsException("Bad credentials");
        }
        return super.getAuthenticationManager().authenticate(authRequest);
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
//        this.authenticationManager = authenticationManager;
    }

    /*@Override
    public void successfulAuthentication(HttpServletRequest request,
                                         HttpServletResponse response, FilterChain chain, Authentication authResult){

    }*/
}
