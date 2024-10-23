package com.shoppingoo.domain.user.controller;
import com.shoppingoo.common.api.Api;
import com.shoppingoo.common.error.ErrorCode;
import com.shoppingoo.common.exception.ApiException;
import com.shoppingoo.domain.token.business.TokenBusiness;
import com.shoppingoo.domain.user.business.UserBusiness;
import com.shoppingoo.domain.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="http://localhost:3000", allowedHeaders="POST")
public class UserApiController {

    private final UserBusiness userBusiness;
    private final TokenBusiness tokenBusiness;

    @GetMapping("/info")
    public Api<UserResponse> info(@RequestHeader("Authorization") String accessToken) {
        String loginId = tokenBusiness.validationAccessToken(accessToken);
        if (loginId == null) {
            throw new ApiException(ErrorCode.BAD_REQUEST, "인증 실패");
        }

        // 로그인 ID를 사용하여 사용자 정보를 조회
        UserResponse response = userBusiness.info(loginId);
        return Api.OK(response);
    }

    @GetMapping("/username")
    public Api<String> getUsername(@RequestHeader("Authorization") String accessToken) {
        // 토큰을 검증하여 로그인 ID를 가져옵니다.
        String loginId = tokenBusiness.validationAccessToken(accessToken);
        if (loginId == null) {
            throw new ApiException(ErrorCode.BAD_REQUEST, "인증 실패");
        }

        // 로그인 ID를 사용하여 사용자 이름을 조회
        String username = userBusiness.getUsernameByLoginId(loginId);
        return Api.OK(username);
    }
}