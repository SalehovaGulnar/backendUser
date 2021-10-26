package com.example.backenduser.serviceImpl;

import com.example.backenduser.dto.UserCreateDTO;
import com.example.backenduser.dto.UserSelectDTO;
import com.example.backenduser.dto.UserUpdateDTO;
import com.example.backenduser.entity.User;
import com.example.backenduser.exception.NotFoundException;
import com.example.backenduser.repository.UserRepository;
import com.example.backenduser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public UserSelectDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return UserSelectDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserSelectDTO> getUsers() {
        return userRepository.findAll().stream().map(UserSelectDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserSelectDTO createUser(UserCreateDTO userCreateDTO) {
        User user = userRepository.save(new User(userCreateDTO.getUsername(), userCreateDTO.getFirstName(),userCreateDTO.getLastName()));
        return UserSelectDTO.of(user);
    }

    @Override
    @Transactional
    public UserSelectDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());
        user.setUsername(userUpdateDTO.getUsername());
        User updateUser = userRepository.save(user);
        return UserSelectDTO.of(updateUser);
    }

    @Override
    @Transactional
    public UserSelectDTO deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.deleteById(id);
        return UserSelectDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserSelectDTO> getUsersSlice(Pageable pageable) {
        return userRepository.findAll(pageable).stream().map(UserSelectDTO::of).collect(Collectors.toList());
    }

    @Override
    public boolean existsUserByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }

}
