package com.alfarizi.budgetin.controller;

import com.alfarizi.budgetin.dto.BaseResponseDto;
import com.alfarizi.budgetin.service.intr.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.alfarizi.budgetin.constant.Path.USER_PATH;
import static com.alfarizi.budgetin.utils.ResponseUtil.success;

@RestController
@RequestMapping(USER_PATH)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<BaseResponseDto> getUser () {
        return success(userService.getAuthenticatedUser());
    }
}
