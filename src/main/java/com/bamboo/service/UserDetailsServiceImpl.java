package com.bamboo.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDetailsServiceImpl
 * @Description UserDetailsServiceImpl
 * @Author zhuqyang
 * @Date 2020/5/21 16:37
 * @Version 1.0
 */
public class UserDetailsServiceImpl implements UserDetailsService{

    public UserDetails loadUserByUsername(String username){
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        authorities.add(new SimpleGrantedAuthority("ROLE_PRODUCT"));
        UserDetails userDetails = new User(username,"user",authorities);
        return userDetails;
    }
}
