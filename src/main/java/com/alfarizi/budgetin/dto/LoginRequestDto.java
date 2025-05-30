package com.alfarizi.budgetin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class LoginRequestDto {

    @NotBlank
    @JsonProperty
    private String email;

    @NotBlank
    @JsonProperty
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
