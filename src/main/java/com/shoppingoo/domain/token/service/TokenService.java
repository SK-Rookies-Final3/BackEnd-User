package com.shoppingoo.domain.token.service;
import com.shoppingoo.common.error.ErrorCode;
import com.shoppingoo.common.exception.ApiException;
import com.shoppingoo.domain.token.Ifs.TokenHelperIfs;
import com.shoppingoo.domain.token.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenHelperIfs tokenHelperIfs;

    // 토큰 생성
    public TokenDto issueAccessToken(String loginId){
        var data = new HashMap<String, Object>();
        data.put("loginId", loginId);
        return tokenHelperIfs.issueAccessToken(data);

    }

    // 토큰 재발행
    public TokenDto issueRefreshToken(String loginId){
        var data = new HashMap<String, Object>();
        data.put("loginId", loginId);
        return tokenHelperIfs.issueAccessToken(data);

    }

    // 토큰 검증
    public String validationToken(String token){
        var map = tokenHelperIfs.validationTokenWithThrow(token);
        var loginId = map.get("loginId");
        Objects.requireNonNull(loginId, () ->{throw new ApiException(ErrorCode.NULL_POINT);});
        return loginId.toString();

    }

}