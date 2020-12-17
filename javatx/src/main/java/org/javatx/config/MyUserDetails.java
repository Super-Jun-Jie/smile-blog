package org.javatx.config;

import org.javatx.pojo.User;
import org.javatx.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/3 8:50
 */
@Component
public class MyUserDetails implements UserDetailsService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public MyUserDetails(UserService userService,PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+"admin"));
        User user = userService.findByUsername(username);
        if (StringUtils.isEmpty(user)){
            throw new UsernameNotFoundException("用户不存在");
        }
        org.springframework.security.core.userdetails.User userdetails = new org.springframework.security.core.userdetails.User(user.getUsername(),passwordEncoder.encode(user.getPassword()),authorities);
        return userdetails;
    }
}
