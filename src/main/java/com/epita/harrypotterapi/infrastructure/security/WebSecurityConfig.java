package com.epita.harrypotterapi.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(login ->
                        login
                                .loginPage("/login")
                                .failureForwardUrl("/login?error")
                                .defaultSuccessUrl("/api/swagger")
                                .usernameParameter("username")
                                .passwordParameter("password")
                )
                .authorizeHttpRequests(authorization ->
                        authorization
                                .requestMatchers("/login", "/error")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        List<UserDetails> users =List.of(
                User.builder()
                        .passwordEncoder(passwordEncoder::encode)
                        .username("h.potter")
                        .password("quidditch")
                        .roles("STUDENT")
                        .build(),
                User.builder()
                        .passwordEncoder(passwordEncoder::encode)
                        .username("h.granger")
                        .password("devoirs")
                        .roles("STUDENT")
                        .build(),
                User.builder()
                        .passwordEncoder(passwordEncoder::encode)
                        .username("r.weasley")
                        .password("chocogrenouille")
                        .roles("STUDENT")
                        .build(),
                User.builder()
                        .passwordEncoder(passwordEncoder::encode)
                        .username("m.mcgonagall")
                        .password("chat")
                        .roles("PROFESSOR")
                        .build(),
                User.builder()
                        .passwordEncoder(passwordEncoder::encode)
                        .username("s.rogue")
                        .password("lily")
                        .roles("PROFESSOR")
                        .build(),
                User.builder()
                        .passwordEncoder(passwordEncoder::encode)
                        .username("a.dumbledore")
                        .password("sorbet_citron")
                        .roles("DIRECTOR")
                        .build()
        );

        return new InMemoryUserDetailsManager(users);
    }

    private static final List<String> PUBLIC_URLS = List.of(
            "/api/swagger",
            "/api/swagger-ui/**",
            "/api/swagger-ui.html",
            "/api/v3/api-docs/**"
    );
}