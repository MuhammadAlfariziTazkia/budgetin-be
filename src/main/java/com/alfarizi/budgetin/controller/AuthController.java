package com.alfarizi.budgetin.controller;

import com.alfarizi.budgetin.dto.BaseResponseDto;
import com.alfarizi.budgetin.dto.LoginRequestDto;
import com.alfarizi.budgetin.dto.RegisterRequestDto;
import com.alfarizi.budgetin.service.intr.JWTService;
import com.alfarizi.budgetin.service.intr.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import static com.alfarizi.budgetin.constant.Path.*;
import static com.alfarizi.budgetin.utils.ResponseUtil.success;

@RestController
@RequestMapping(AUTH_PATH)
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserService userService;

    @PostMapping(LOGIN)
    public ResponseEntity<BaseResponseDto> login (@RequestBody LoginRequestDto requestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDto.getEmail(),
                        requestDto.getPassword()
                )
        );

        return success(jwtService.generateToken(requestDto.getEmail()));
    }

    @PostMapping(REGISTER)
    public ResponseEntity<BaseResponseDto> register(@RequestBody RegisterRequestDto requestDto) {
        return success(userService.register(requestDto));
    }
}
