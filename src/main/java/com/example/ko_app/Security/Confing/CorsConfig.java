//package com.example.ko_app.Security.Confing;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import java.util.Arrays;
//
//@Configuration
//public class CorsConfig {
//
//    @Bean
//    public CorsFilter corsFilter() {
//        return new CorsFilter(request -> {
//            CorsConfiguration config = new CorsConfiguration();
//
//            String origin = request.getHeader("Origin");
//            if (origin != null && origin.matches("http://localhost(:\\d+)?")) {
//                // Allow the exact localhost origin with any port
//                config.setAllowedOrigins(Arrays.asList(origin));
//            }
//            // Optionally add other allowed origins here if needed
//
//            config.addAllowedHeader("*");
//            config.addAllowedMethod("*");
//            config.setAllowCredentials(true);
//
//            return config;
//        });
//    }
//}
