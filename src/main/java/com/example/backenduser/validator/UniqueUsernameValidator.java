package com.example.backenduser.validator;

import com.example.backenduser.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Data
public final class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    UserService userService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return !userService.existsUserByUsername(username);
    }

}
