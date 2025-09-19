package com.example.ComplaintManagementProject.Config;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.ComplaintManagementProject.Service.AuthencationService;

import java.io.IOException;

@Configuration
public class WebSecurityConfig {
    @Autowired
    private AuthencationService authencationService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(authencationService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/register.html", "/login.html", "/register").permitAll()
                .requestMatchers("/Student.html").hasRole("STUDENT")
                .requestMatchers("/Teacher.html").hasRole("TEACHER")
                .requestMatchers("/Student/Complaint").hasRole("STUDENT")
                .requestMatchers("/Head/**").hasRole("TEACHER")
                .requestMatchers("/Student/SeeComplaint", "/api/user/me").hasAnyRole("STUDENT", "TEACHER")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .successHandler(customAuthenticationSuccessHandler())
                .permitAll()
            )
            .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login.html?logout")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return (request, response, authentication) -> {
            String redirectUrl = request.getContextPath();
            boolean isTeacher = authentication.getAuthorities().stream()
                    .anyMatch(g -> g.getAuthority().equals("ROLE_TEACHER"));
            boolean isStudent = authentication.getAuthorities().stream()
                    .anyMatch(g -> g.getAuthority().equals("ROLE_STUDENT"));

            if (isTeacher) {
                redirectUrl = "/Teacher.html";
            } else if (isStudent) {
                redirectUrl = "/Student.html";
            }
            response.sendRedirect(redirectUrl);
        };
    }
}



