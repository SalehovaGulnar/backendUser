package com.example.backenduser.service;

import com.example.backenduser.dto.UserCreateDTO;
import com.example.backenduser.dto.UserSelectDTO;
import com.example.backenduser.dto.UserUpdateDTO;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface UserService {

    UserSelectDTO getUserById(Long id);

    List<UserSelectDTO> getUsers();

    UserSelectDTO createUser(UserCreateDTO userCreateDTO);

    UserSelectDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

    UserSelectDTO deleteUser(Long id);

    List<UserSelectDTO> getUsersSlice(Pageable pageable);

    boolean existsUserByUsername(String username);

}

