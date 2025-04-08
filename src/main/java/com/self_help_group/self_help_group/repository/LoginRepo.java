package com.self_help_group.self_help_group.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.self_help_group.self_help_group.domain.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, String> {
    Login findByUsernameAndPassword(String username, String password);

    // boolean findByUsername(String username);

    // Login save(String username, String password);

    // boolean existsByUsername(String username);
}
