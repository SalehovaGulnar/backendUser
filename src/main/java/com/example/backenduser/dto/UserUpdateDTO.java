package com.example.backenduser.dto;

import com.example.backenduser.validator.UniqueUsername;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserUpdateDTO {

    @NotNull(message = "{backenduser.constraints.username.NotNull.message}")
    @Size(min = 5, max = 50, message = "{backenduser.constraints.username.Size.message}")
    @UniqueUsername
    private String username;

    @NotNull(message = "{backenduser.constraints.firstName.NotNull.message}")
    @Size(min = 3, max = 50, message = "{backenduser.constraints.firstName.Size.message}")
    private String firstName;

    @NotNull(message = "{backenduser.constraints.lastName.NotNull.message}")
    @Size(min = 3, max = 50, message = "{backenduser.constraints.lastName.Size.message}")
    private String lastName;

}
