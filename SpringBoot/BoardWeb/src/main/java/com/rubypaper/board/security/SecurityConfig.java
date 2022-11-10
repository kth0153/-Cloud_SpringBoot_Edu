package com.rubypaper.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityUserDetailsService userDetailsService;


    protected void configure(HttpSecurity security) throws Exception{
        security.authorizeRequests().antMatchers("/","/system/**").permitAll();
        security.authorizeRequests().antMatchers("/board/**").authenticated();
        security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

        security.csrf().disable();
        security.formLogin().loginPage("/system/login").defaultSuccessUrl("/board/getBoardList",true);
        security.exceptionHandling().accessDeniedPage("/system/accessDenied");
        security.logout().logoutUrl("/system/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
        security.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
