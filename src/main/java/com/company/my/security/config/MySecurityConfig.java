package com.company.my.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置的登陆功能
        // 1.访问/login请求，来到登陆页
        // 2.如果登陆失败，重定向到/login?error
        // 3.可以定制登陆提交的用户名密码字段名，登录页，失败页等
        //      1.默认访问登陆页面的请求的post请求为登陆请，
        //      2.定制登陆页面后，默认访问登陆页面的请求的post请求是登陆请求

//        http.formLogin()
//                .usernameParameter("username")  //指定用户名字段
//                .passwordParameter("password")  //指定密码字段
//                .loginPage("/loginPage")        //指定登陆页请求
//                .loginProcessingUrl("/loginPage");  //指定处理登陆的请求

        //开启自动配置的注销功能
        // 1.访问/logout,退出登陆，并注销session
        // 2.退出成功后，重定向到
        http.logout()
        .logoutSuccessUrl("/login");  //配置注销成功后，返回首页


        //开启记住我功能
        http.rememberMe();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2")
                .and()
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2","VIP3");
    }
}
