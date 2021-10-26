package com.example.backenduser.controller;

import com.example.backenduser.config.ResponseTemp;
import com.example.backenduser.dto.UserCreateDTO;
import com.example.backenduser.dto.UserSelectDTO;
import com.example.backenduser.dto.UserUpdateDTO;
import com.example.backenduser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<UserSelectDTO> getUserById(@PathVariable Long id) {
        UserSelectDTO userSelectDTO = userService.getUserById(id);
        return ResponseEntity.ok(userSelectDTO);
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserSelectDTO>> getUsers() {
        List<UserSelectDTO> userSelectDTOs = userService.getUsers();
        return ResponseEntity.ok(userSelectDTOs);
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        UserSelectDTO userSelectDTO = userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new ResponseTemp("User created"));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserSelectDTO> updateUser(@PathVariable("id") Long id,
                                        @RequestBody UserUpdateDTO userUpdateDTO) {
        UserSelectDTO userSelectDTO = userService.updateUser(id, userUpdateDTO);
        return ResponseEntity.ok(userSelectDTO);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteteUser(@PathVariable("id") Long id) {
        UserSelectDTO userSelectDTO = userService.deleteUser(id);
        return ResponseEntity.ok(new ResponseTemp("User deleted"));
    }

    @GetMapping("/user/slice")
    public ResponseEntity<List<UserSelectDTO>> getUsersSlice(Pageable pageable) {
        List<UserSelectDTO> userSelectDTOs = userService.getUsersSlice(pageable);
        return ResponseEntity.ok(userSelectDTOs);
    }

}

