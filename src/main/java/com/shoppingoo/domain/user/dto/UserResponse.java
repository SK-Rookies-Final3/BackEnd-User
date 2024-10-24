package com.shoppingoo.domain.user.dto;
import com.shoppingoo.db.user.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String adress;
    private int age;
    private String gender;
    private int height;
    private int weight;
    private String email;
    private UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime lastAccpetedAt;
}
