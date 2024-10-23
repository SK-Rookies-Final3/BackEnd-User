package com.shoppingoo.domain.token.business;

import com.shoppingoo.common.annotation.Business;
import com.shoppingoo.common.error.ErrorCode;
import com.shoppingoo.common.exception.ApiException;
import com.shoppingoo.db.user.User;
import com.shoppingoo.domain.token.controller.model.TokenResponse;
import com.shoppingoo.domain.token.converter.TokenConverter;
import com.shoppingoo.domain.token.service.TokenService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@Business
public class TokenBusiness {

    private final TokenService tokenService;

    private final TokenConverter tokenConverter;


    /**
     * 1. user entity user Id 추출
     * 2. access, refresh token 발행
     * 3. converter -> token response로 변경
     */

    public TokenResponse issueToken(User userEntity){

        return Optional.ofNullable(userEntity)
                .map(user -> {
                    return user.getUsername();
                })
                .map(user -> {
                    String loginId = userEntity.getLoginId();
                    var accessToken = tokenService.issueAccessToken(loginId);
                    var refreshToken = tokenService.issueRefreshToken(loginId);
                    return tokenConverter.toResponse(accessToken, refreshToken);
                })
                .orElseThrow(
                        ()-> new ApiException(ErrorCode.NULL_POINT)
                );


    }

    public String validationAccessToken(String accessToken){
        var loginId = tokenService.validationToken(accessToken);
        return loginId;
    }

}