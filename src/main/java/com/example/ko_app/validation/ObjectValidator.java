package com.example.ko_app.validation;

import com.example.ko_app.Configruration.ObjectNotValidException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectValidator<T>{

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    @Autowired
    private final Validator validator = factory.getValidator();

    public void validate(T ObjectToValidate){
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(ObjectToValidate);
        if (!constraintViolations.isEmpty()) {
            var errorMessages = constraintViolations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());

            throw new ObjectNotValidException();
        }
    }
}
