package com.alfarizi.budgetin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequestDto {

    @NotBlank
    @JsonProperty
    private String email;

    @NotBlank
    @JsonProperty
    private String password;

    @NotBlank
    @JsonProperty
    private String currency;

    @NotBlank
    @JsonProperty
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
