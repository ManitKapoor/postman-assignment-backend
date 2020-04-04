package com.postman.assignment.assignmentbackend;


import com.postman.assignment.assignmentbackend.constants.Constants;
import com.postman.assignment.assignmentbackend.service.auth.AuthFilter;
import com.postman.assignment.assignmentbackend.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthFilter authFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
        http.cors(httpSecurityCorsConfigurer -> {
            httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource());
        });
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilter(authFilter).addFilterBefore(new ExceptionTranslationFilter(
                        new Http403ForbiddenEntryPoint() ),
                authFilter.getClass()
        ).authorizeRequests().antMatchers("/", "/assets/**","/register", "/login" ,"/dashboard", "/assignment").permitAll()
                .anyRequest().authenticated();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin(Constants.ALLOWED_ORIGINS);
        config.addAllowedOrigin(Constants.ALLOWED_HEADERS);
        for (Constants.HTTP_METHOD http_method:Constants.HTTP_METHOD.values()) {
            config.addAllowedMethod(http_method.name());
        }
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}