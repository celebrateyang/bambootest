package com.bamboo.provider;/**
 * Created by zhuqyang on 2020/5/21.
 */

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyProvider
 * @Description MyProvider
 * @Author zhuqyang
 * @Date 2020/5/21 20:34
 * @Version 1.0
 */
public class MyProvider implements AuthenticationProvider {
    //在这里指定自己的认证流程,如果认证成功返回UsernamePasswordAuthenticationToken,并携带角色信息
    //如果认为认证失败,可以抛出异常
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //new UsernamePasswordAuthenticationToken(user, smscode, authorities);
        String username = authentication.getName();
        Object details = authentication.getDetails();
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        /*authorities.add(new SimpleGrantedAuthority("ROLE_PRODUCT"));*/
        if("user1".equals(username)){
            throw new BadCredentialsException("Bad credentials");
        }
        return new UsernamePasswordAuthenticationToken(username, "", authorities);
    }

    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
