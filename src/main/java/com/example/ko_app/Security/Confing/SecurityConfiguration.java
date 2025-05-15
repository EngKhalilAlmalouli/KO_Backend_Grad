//package com.example.ko_app.Security.Confing;
//
//import com.example.ko_app.Security.User.Role;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfiguration {
//
//    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//    private final AuthenticationProvider authenticationProvider;
//
//    // Constructor
//    public SecurityConfiguration(JwtAuthenticationFilter jwtAuthenticationFilter,
//                                 AuthenticationProvider authenticationProvider) {
//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//        this.authenticationProvider = authenticationProvider;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(req ->
//                        req
//                                .requestMatchers("/api/v1/auth/login").permitAll()
//                                .requestMatchers("/api/v1/auth/register").permitAll()
//                                .requestMatchers("api/v1/auth/admin/**").hasRole(Role.ADMIN.name())
//                                .requestMatchers("api/v1/auth/management/**")
//                                .hasAnyRole(Role.ADMIN.name(), Role.SUBADMIN.name())
//                )
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//}