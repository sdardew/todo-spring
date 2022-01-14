package com.example.demo.config;

import com.example.demo.security.JwtAuthenticationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http security builder
        http.cors()
            .and()
                .csrf().disable()
                .httpBasic().disable() // token 사용이기 때문에 basic 인증 disable
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)// session 기반이 아님
            .and()
                .authorizeRequests().antMatchers("/", "/auth/**").permitAll() // 인증 안 해도 되는 경로
                .anyRequest().authenticated(); // 그 외의 경로는 모두 인증

        // filter 등록
        // 요청마다 CorsFilter 실행 후 jwtAuthenticationFilter 실행
        http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class);
    }
}
