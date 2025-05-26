package com.example.ko_app.Security.Auth;

public class AuthenticationResponse {

    private String token;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "token='" + token + '\'' +
                '}';
    }

    // Builder class
    public static class Builder {
        private String token;

        public Builder() {
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public AuthenticationResponse build() {
            return new AuthenticationResponse(token);
        }
    }

    // Static method to start builder
    public static Builder builder() {
        return new Builder();
    }
}