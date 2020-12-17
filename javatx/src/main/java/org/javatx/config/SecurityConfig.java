package org.javatx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //密码加密方式
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("admin");
//    }
    //    /**
//     * 配置用户权限组和接口路径的关系
//     * 和一些其他配置
//     *
//     * @param http
//     * @throws Exception
//     */
//    @Override
//     protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()     // 对请求进行验证
//                .antMatchers("/").permitAll()
//                //.antMatchers("/admin/**").hasRole("ROLE_ADMIN")     // 必须有ADMIN权限
//                //.antMatchers("/user/**").hasAnyRole("ROLE_USER", "ROLE_ADMIN")       //有任意一种权限
//                .anyRequest()     //任意请求（这里主要指方法）
//                .authenticated()   //// 需要身份认证
//                .and()   //表示一个配置的结束
//                .formLogin().permitAll()  //开启SpringSecurity内置的表单登录，会提供一个/login接口
//                .and()
//                .logout().permitAll()  //开启SpringSecurity内置的退出登录，会为我们提供一个/logout接口
//                .and()
//                .csrf().disable();    //关闭csrf跨站伪造请求
//    }

}