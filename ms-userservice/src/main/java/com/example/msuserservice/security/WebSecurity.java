package com.example.msuserservice.security;

import com.example.msuserservice.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final UsersService usersService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Environment env;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();


        http.authorizeRequests()
                .antMatchers("/**")
                .hasIpAddress("192.168.0.0") /*TODO: Change to Gateway IP*/
                .and()
                .addFilter(getAuthenticationFilter());

        http.headers().frameOptions().disable();
    }


    private AuthenticationFilter getAuthenticationFilter() throws Exception {

        AuthenticationFilter authenticationFilter = new AuthenticationFilter(usersService, env, authenticationManager());

        return authenticationFilter;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersService).passwordEncoder(bCryptPasswordEncoder);
    }

}
