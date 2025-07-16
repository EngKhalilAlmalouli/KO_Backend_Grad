package com.example.ko_app.Security.Auth;

import com.example.ko_app.Security.User.User;
import com.example.ko_app.Security.User.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3003")
@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserRepository userRepository;

    public AuthenticationController(AuthenticationService service, UserRepository userRepository) {
        this.service = service;
        this.userRepository = userRepository;
    }

        @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.login(request));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userRepository.findAll();  // Fetch all users from the repository
        // Convert users to UserResponse DTOs
        List<UserResponse> userResponses = users.stream()
                .map(user -> new UserResponse(user.getId(), user.getFirstname(), user.getLastname(), user.getEmail()))
                .collect(Collectors.toList());

        // Wrap the list of users inside a 'users' object
        return ResponseEntity.ok().body(
                new ResponseWrapper(userResponses)
        );
    }

    // Response wrapper class
    public static class ResponseWrapper {
        private List<UserResponse> users;

        public ResponseWrapper(List<UserResponse> users) {
            this.users = users;
        }

        public List<UserResponse> getUsers() {
            return users;
        }

        public void setUsers(List<UserResponse> users) {
            this.users = users;
        }
    }

}
