package com.example.backenduser.dto;

import com.example.backenduser.entity.User;
import lombok.Getter;
import java.io.Serializable;

@Getter
public final class UserSelectDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String username;

    private final String firstName;

    private final String lastName;

    private UserSelectDTO(String username, String firstName, String lastName) {

        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static UserSelectDTO of(User user) {
        return new UserSelectDTO(user.getUsername(), user.getFirstName(), user.getLastName());
    }

}
