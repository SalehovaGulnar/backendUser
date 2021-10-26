package com.example.backenduser.repository;

import com.example.backenduser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByUsername(String username);

}
