package com.epita.harrypotterapi.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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
//        http.cors();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.anonymous().authorities("ROLE_ANONYMOUS");
//        http.authorizeHttpRequests()
//                .requestMatchers(DIRECTOR_URLS.toArray(new String[0])).hasRole("DIRECTOR")
//                .requestMatchers(PROFESSOR_URLS.toArray(new String[0])).hasAnyRole("PROFESSOR", "DIRECTOR")
//                .requestMatchers(PUBLIC_URLS.toArray(new String[0])).permitAll()
//                .anyRequest().permitAll();
//        http.formLogin().successForwardUrl("/api/swagger");

//        http
//                .cors()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/**").permitAll()
//                .requestMatchers(DIRECTOR_URLS.toArray(new String[0])).hasRole("DIRECTOR")
//                .requestMatchers(PROFESSOR_URLS.toArray(new String[0])).hasAnyRole("PROFESSOR", "DIRECTOR")
//                .requestMatchers(PUBLIC_URLS.toArray(new String[0])).permitAll()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin().successForwardUrl("/api/swagger");

        http
                .authorizeHttpRequests()
                .requestMatchers("/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .csrf().disable();

        return http.build();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        List<UserDetails> users =List.of(
//                User.builder()
//                        .passwordEncoder(passwordEncoder::encode)
//                        .username("h.potter")
//                        .password("quidditch")
//                        .roles("STUDENT")
//                        .build(),
//                User.builder()
//                        .passwordEncoder(passwordEncoder::encode)
//                        .username("h.granger")
//                        .password("devoirs")
//                        .roles("STUDENT")
//                        .build(),
//                User.builder()
//                        .passwordEncoder(passwordEncoder::encode)
//                        .username("r.weasley")
//                        .password("chocogrenouille")
//                        .roles("STUDENT")
//                        .build(),
//                User.builder()
//                        .passwordEncoder(passwordEncoder::encode)
//                        .username("m.mcgonagall")
//                        .password("chat")
//                        .roles("PROFESSOR")
//                        .build(),
//                User.builder()
//                        .passwordEncoder(passwordEncoder::encode)
//                        .username("s.rogue")
//                        .password("lily")
//                        .roles("PROFESSOR")
//                        .build(),
//                User.builder()
//                        .passwordEncoder(passwordEncoder::encode)
//                        .username("a.dumbledore")
//                        .password("sorbet_citron")
//                        .roles("DIRECTOR")
//                        .build()
//        );
//
//        return new InMemoryUserDetailsManager(users);
//    }
//
//    private static final List<String> PUBLIC_URLS = List.of(
//            "/api/swagger",
//            "/api/swagger-ui/**",
//            "/api/swagger-ui.html",
//            "/login"
//    );
//
//    private static final List<String> PROFESSOR_URLS = List.of(
//            "/api/reservations/room"
//    );
//
//    private static final List<String> DIRECTOR_URLS = List.of(
//            "/api/rooms/**"
//    );
}
