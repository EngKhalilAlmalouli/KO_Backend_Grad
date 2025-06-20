package com.example.ko_app.Security.Auth;

public class AuthenticationResponse {

    private String token;
    private UserResponse user;


    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String token, UserResponse user) {
        this.token = token;
        this.user = user;

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "token='" + token + '\'' +
                ", user=" + user +
                '}';
    }

    // Builder class
    public static class Builder {
        private String token;
        private UserResponse user;


        public Builder() {
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder user(UserResponse user) {
            this.user = user;
            return this;

        }
            public AuthenticationResponse build () {
                return new AuthenticationResponse(token, user);
            }
        }

        // Static method to start builder
        public static Builder builder() {
            return new Builder();
        }
    }
