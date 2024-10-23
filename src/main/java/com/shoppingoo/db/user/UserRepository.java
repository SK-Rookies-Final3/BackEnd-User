package com.shoppingoo.db.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByIdAndPasswordHash(String Id, String password);
    Optional<User> findInfoById(String Id);
    Optional<User> findById(String Id);
    Optional<User> findUsernameBynId(String Id);
    Optional<User> findByUsername(String username); // 새로운 메서드 추가
    Optional<User> findByLoginId(String loginId);  // 새로운 메서드 추가 22
}
