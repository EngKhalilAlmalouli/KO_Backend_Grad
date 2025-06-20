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
//    @Configuration
//    @EnableWebSecurity
//    @EnableMethodSecurity
//    public class SecurityConfiguration {
//
//        private final JwtAuthenticationFilter jwtAuthenticationFilter;
//        private final AuthenticationProvider authenticationProvider;
//
//        // Constructor
//        public SecurityConfiguration(JwtAuthenticationFilter jwtAuthenticationFilter,
//                                     AuthenticationProvider authenticationProvider) {
//            this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//            this.authenticationProvider = authenticationProvider;
//        }
//
//        @Bean
//        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//            http
//                    .csrf(AbstractHttpConfigurer::disable)
//                    .authorizeHttpRequests(req ->
//                            req
//                                    .requestMatchers("/api/v1/auth/login").permitAll()
//                                    .requestMatchers("/api/v1/auth/register").permitAll()
////                                    .requestMatchers("/api/v1/auth/admin/**").hasRole(Role.ADMIN.name())
//
////                                    .requestMatchers("/api/v1/auth/register/customers").hasRole(Role.CUSTOMER.name())
//
//                                    .requestMatchers("/api/products/**").hasRole(Role.CUSTOMER.name())
//                                    .requestMatchers("/api/category/**").hasRole(Role.CUSTOMER.name())
//                                    .requestMatchers("/api/reports/**").hasRole(Role.CUSTOMER.name())
//                                    .requestMatchers("/api/reviews/**").hasRole(Role.CUSTOMER.name())
//                                    .requestMatchers("/api/points/**").hasRole(Role.CUSTOMER.name())
//                                    .requestMatchers("/api/files/**").hasRole(Role.CUSTOMER.name())
////                                    .requestMatchers("/api/orders/**").hasRole(Role.CUSTOMER.name())
//                                    .requestMatchers("/api/orders/**").permitAll()
//
//
////                                    .requestMatchers("/api/v1/auth/management/**")
////                                    .hasAnyRole(Role.ADMIN.name(), Role.SUBADMIN.name(), Role.CUSTOMER.name(), Role.DRIVER.name())
//                    )
//                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                    .authenticationProvider(authenticationProvider)
//                    .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//            return http.build();
//        }
//    }

package com.example.ko_app.Security.Confing;

import com.example.ko_app.Security.User.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    // Constructor
    public SecurityConfiguration(JwtAuthenticationFilter jwtAuthenticationFilter,
                                 AuthenticationProvider authenticationProvider) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(req ->
                        req
                                .requestMatchers("/api/v1/auth/login").permitAll()
                                .requestMatchers("/api/v1/auth/register").permitAll()

                                .requestMatchers("/api/products/**").hasAuthority(Role.CUSTOMER.name())
                                .requestMatchers("/api/category/**").hasAuthority(Role.CUSTOMER.name())
                                .requestMatchers("/api/reports/**").hasAuthority(Role.CUSTOMER.name())
                                .requestMatchers("/api/reviews/**").hasAuthority(Role.CUSTOMER.name())
                                .requestMatchers("/api/points/**").hasAuthority(Role.CUSTOMER.name())
                                .requestMatchers("/api/files/**").hasAuthority(Role.CUSTOMER.name())
                                .requestMatchers("/api/orders/**").permitAll()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
