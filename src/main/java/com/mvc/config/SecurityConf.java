package com.mvc.config;

import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.mvc.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.mvc.repo", "com.mvc.service"})

public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    private IAppUserService userService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((UserDetailsService) userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
        //xac thuc authentication
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //phan quyen
        http.authorizeRequests()
                .antMatchers("/student**").access("hasRole('ADMIN')")
                .antMatchers("/class**").access("hasRole('USER')")
                .and()
                .formLogin()
                .and()
                .csrf();
        super.configure(http);
    }
}
