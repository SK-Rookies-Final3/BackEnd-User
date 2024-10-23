package com.shoppingoo.domain.user.dto;
import com.shoppingoo.common.error.ErrorCode;
import com.shoppingoo.common.exception.ApiException;
import com.shoppingoo.db.user.User;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
//@Converter
public class UserMapper {

    public User toEntity(UserRegisterRequest request){

        // Request 데이터 유효성 검사 추가
        if(request == null) {
            throw new ApiException(ErrorCode.NULL_POINT, "UserRegisterRequest Null");
        }

        // 엔티티로 변환
        return User.builder()
                .loginId(request.getLoginId())
                .passwordHash(request.getPasswordHash())
                .build();
    }

    public UserResponse toResponse(User user) {

        return Optional.ofNullable(user)
                .map(it -> UserResponse.builder()
                        .id(user.getId())
                        .loginId(user.getLoginId())
                        .username(user.getUsername())
                        .passwordHash(user.getPasswordHash())
                        .createdAt(user.getCreatedAt())
                        .lastLogin(user.getLastLogin())
                        .isActive(user.getIsActive())
                        .build())
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "UserEntity Null"));
    }
}