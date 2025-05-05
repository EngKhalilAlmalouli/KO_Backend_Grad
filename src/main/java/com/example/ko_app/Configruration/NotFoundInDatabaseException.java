package com.example.ko_app.Configruration;

public class NotFoundInDatabaseException extends Exception {
    public NotFoundInDatabaseException() {
    }

    public NotFoundInDatabaseException(String message) {
        super(message);
    }

}
