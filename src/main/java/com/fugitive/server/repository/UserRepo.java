package com.fugitive.server.repository;

import com.fugitive.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {

    Optional<User> findUserByEmail(String email);
}
