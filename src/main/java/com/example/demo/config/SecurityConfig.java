package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final SuccessHandler successHandler;
    private final FailureHandler failureHandler;
@Autowired
private CustomUserDetailService customUserDetailService;
    public SecurityConfig(SuccessHandler successHandler,FailureHandler failureHandler) {
        this.successHandler = successHandler;
        this.failureHandler = failureHandler;
    }

    private final String[] publicURI = {
            "/api/**",
            "/WEB-INF/**",
            "/login"
    };

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers(publicURI).permitAll()
                    .requestMatchers("/common")
                    .hasAnyAuthority("ADMIN", "USER")
                    .requestMatchers("/user/**").hasAuthority("USER")
                    .anyRequest().authenticated()
            )
            .formLogin(login -> login
                    .loginPage("/login")
                    .loginProcessingUrl("/api/loginProcess")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .successHandler(successHandler)
                    .failureHandler(failureHandler)
                    .permitAll()
            ) .logout(logout -> logout
                    .logoutUrl("/logout")
                    .permitAll()
                );

        return http.build();
    }


    @Bean
     AuthenticationProvider authentication() {

        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(customUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }
   
}