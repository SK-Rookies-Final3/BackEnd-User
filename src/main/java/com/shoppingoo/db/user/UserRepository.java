package com.shoppingoo.db.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findPasswordByUsername(String password);
    Optional<User> findByNickname(String Nickname);
}