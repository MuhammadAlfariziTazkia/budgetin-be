package com.alfarizi.budgetin.service.intr;

import com.alfarizi.budgetin.dto.RegisterRequestDto;
import com.alfarizi.budgetin.model.User;

import java.util.Optional;

public interface UserService {

    User register(RegisterRequestDto requestDto);

    Optional<User> findByEmail(String email);

    User getAuthenticatedUser();
}
