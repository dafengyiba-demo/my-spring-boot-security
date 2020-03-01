package com.company.my.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * spring security:
 *  1.引入：
 *      spring-boot-starter-security
 *  2.编写一个配置类：
 *      继承WebSecurityConfigurerAdapter类，并被@EnableWebSecurity注解
 *  3.控制请求的访问权限：
 *
 *
 */
@SpringBootApplication
public class MySpringBootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootSecurityApplication.class, args);
    }

}
