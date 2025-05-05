package com.example.ko_app.Configruration;

import javax.naming.AuthenticationException;

public  class UsernameNotFoundException extends AuthenticationException {
    public UsernameNotFoundException(String msg) {
        super(msg);
    }

    public UsernameNotFoundException(String msg, Throwable cause) {
        super(msg);
    }
}