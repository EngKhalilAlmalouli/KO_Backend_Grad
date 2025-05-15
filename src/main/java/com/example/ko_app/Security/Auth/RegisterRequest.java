//package com.example.ko_app.Security.Auth;
//
//import com.example.ko_app.Security.User.Role;
//
//public class RegisterRequest {
//
//    private String firstname;
//    private String lastname;
//    private String email;
//    private String password;
//    private Role role;
//
//    public RegisterRequest() {
//    }
//
//    public RegisterRequest(String firstname, String lastname, String email, String password, Role role) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.email = email;
//        this.password = password;
//        this.role = role;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public javax.management.relation.Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    @Override
//    public String toString() {
//        return "RegisterRequest{" +
//                "firstname='" + firstname + '\'' +
//                ", lastname='" + lastname + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", role=" + role +
//                '}';
//    }
//
//    // Builder class
//    public static class Builder {
//        private String firstname;
//        private String lastname;
//        private String email;
//        private String password;
//        private Role role;
//
//        public Builder() {
//        }
//
//        public Builder firstname(String firstname) {
//            this.firstname = firstname;
//            return this;
//        }
//
//        public Builder lastname(String lastname) {
//            this.lastname = lastname;
//            return this;
//        }
//
//        public Builder email(String email) {
//            this.email = email;
//            return this;
//        }
//
//        public Builder password(String password) {
//            this.password = password;
//            return this;
//        }
//
//        public Builder role(Role role) {
//            this.role = role;
//            return this;
//        }
//
//        public RegisterRequest build() {
//            return new RegisterRequest(firstname, lastname, email, password, role);
//        }
//    }
//
//    // Static method to start building
//    public static Builder builder() {
//        return new Builder();
//    }
//}
