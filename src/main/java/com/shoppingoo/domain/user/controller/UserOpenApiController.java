package com.shoppingoo.domain.user.controller;

import com.shoppingoo.common.api.Api;
import com.shoppingoo.domain.token.controller.model.TokenResponse;
import com.shoppingoo.domain.user.business.UserBusiness;
import com.shoppingoo.domain.user.dto.UserLoginRequest;
import com.shoppingoo.domain.user.dto.UserRegisterRequest;
import com.shoppingoo.domain.user.dto.UserResponse;
import com.shoppingoo.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/open-api")
@CrossOrigin(origins="http://localhost:3000", allowedHeaders="*")
public class UserOpenApiController {

    private final UserService userService;
    private final UserBusiness userBusiness;

    @PostMapping("/register")
    public ResponseEntity<Api<UserResponse>> register(
            @Valid @RequestBody UserRegisterRequest request
    ) {
        var response = userBusiness.register(request);  // response가 UserResponse 타입이어야 함
        return ResponseEntity.ok(Api.OK(response));
    }

    @PostMapping("/login")
    public ResponseEntity<Api<TokenResponse>> login(
            @Valid @RequestBody UserLoginRequest request
    ){
        var response = userBusiness.login(request);
        return ResponseEntity.ok(Api.OK(response));
    }
}