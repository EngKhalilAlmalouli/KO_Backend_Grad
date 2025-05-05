package com.example.ko_app.Configruration;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class ObjectNotValidException extends RuntimeException {

    private Set<String> errorMessages;

}
