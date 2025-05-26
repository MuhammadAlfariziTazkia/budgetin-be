package com.alfarizi.budgetin.service.impl;

import com.alfarizi.budgetin.dto.RegisterRequestDto;
import com.alfarizi.budgetin.model.User;
import com.alfarizi.budgetin.repository.UserRepository;
import com.alfarizi.budgetin.service.intr.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(RegisterRequestDto requestDto) {
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setName(requestDto.getName());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setCurrency(requestDto.getCurrency());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authenticatedEmail = (String) authentication.getPrincipal();
        return findByEmail(authenticatedEmail)
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));
    }
}
