package com.olegnew.jvcboxv1.config;

import com.olegnew.jvcboxv1.service.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private CustomUserDetailService customUserDetailService;

    @Autowired
    public void setCustomUserDetailService(CustomUserDetailService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("login").permitAll()
                .antMatchers(HttpMethod.GET, "/v1/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/v1/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/v1/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/v1/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/v1/cbox/**").hasAnyRole("OPERATOR", "USER")
                .antMatchers(HttpMethod.PUT, "/v1/cbox/**").hasRole("OPERATOR")
                .antMatchers(HttpMethod.POST, "/v1/cbox/**").hasRole("OPERATOR")
                .antMatchers(HttpMethod.PATCH, "/v1/cbox/**").hasRole("OPERATOR")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(getEncoder());
        authenticationProvider.setUserDetailsService(customUserDetailService);
        return authenticationProvider;
    }
}
