package com.project.code.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {

        http
                .authorizeHttpRequests(auth -> auth
                        // статика
                        .requestMatchers("/css/**", "/js/**", "/fonts/**", "/images/**", "/favicon.ico").permitAll()
                        .requestMatchers("/error").permitAll()

                        // публичные страницы
                        .requestMatchers(HttpMethod.GET, "/", "/search", "/movies").permitAll()
                        .requestMatchers("/login", "/register").permitAll()

                        // только для вошедших (должно стоять ДО общего /movies/*)
                        .requestMatchers("/profile", "/movies/watch/**", "/bookmark/**").authenticated()

                        // карточка фильма
                        .requestMatchers(HttpMethod.GET, "/movies/*").permitAll()

                        // админка и API
                        .requestMatchers("/admin/**", "/api/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.HEAD, "/", "/search", "/movies", "/movies/*").permitAll()

                        // всё остальное закрыто
                        .anyRequest().denyAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
