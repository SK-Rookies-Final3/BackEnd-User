package com.shoppingoo.domain.user.dto;
import com.shoppingoo.common.error.ErrorCode;
import com.shoppingoo.common.exception.ApiException;
import com.shoppingoo.db.user.User;
import com.shoppingoo.common.annotation.Converter;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@Converter
public class UserMapper {

    public User toEntity(UserRegisterRequest request){

        // Request 데이터 유효성 검사 추가
        if(request == null) {
            throw new ApiException(ErrorCode.NULL_POINT, "UserRegisterRequest Null");
        }

        // 엔티티로 변환
        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .build();
    }

    public UserResponse toResponse(User user) {

        return Optional.ofNullable(user)
                .map(it -> UserResponse.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .nickname(user.getNickname())
                        .adress(user.getAddress())
                        .age(user.getAge())
                        .gender(user.getGender())
                        .height(user.getHeight())
                        .weight(user.getWeight())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .createdAt(user.getCreatedAt())
                        .lastAccpetedAt(user.getLastAccpetedAt())
                        .build())
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "UserEntity Null"));
    }
}