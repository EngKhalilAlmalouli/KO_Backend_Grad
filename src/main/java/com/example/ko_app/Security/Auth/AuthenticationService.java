//package com.example.ko_app.Security.Auth;
//
//import com.example.ko_app.Security.Confing.JwtService;
//import com.example.ko_app.Security.User.Role;
//import com.example.ko_app.Security.User.User;
//import com.example.ko_app.Security.User.UserRepository;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthenticationService {
//
//    private final UserRepository userRepository;
//    private  final PasswordEncoder passwordEncoder;
//    private final JwtService jwtService;
//    private final AuthenticationManager authenticationManager;
//
//    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtService = jwtService;
//        this.authenticationManager = authenticationManager;
//    }
//
//    public AuthenticationResponse register(RegisterRequest request) {
//        User user = User.builder()
//                .firstname(request.getFirstname())
//                .lastname(request.getLastname())
//                .email(request.getEmail())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .role(Role.USER)
//                .build();
//        userRepository.save(user);
//        String token = jwtService.generateToken(user);
//        return  AuthenticationResponse.builder()
//                .token(token)
//                .build();
//
//    }
//
//    public AuthenticationResponse login(AuthenticationRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getEmail(),
//                        request.getPassword()
//                )
//        );
//        User user = userRepository.findByEmail(request.getEmail())
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        String token = jwtService.generateToken(user);
//        return  AuthenticationResponse.builder()
//                .token(token)
//                .build();
//
//    }
//}