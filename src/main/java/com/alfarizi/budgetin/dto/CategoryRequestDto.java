package com.alfarizi.budgetin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class CategoryRequestDto {

    @NotBlank
    @JsonProperty
    private String name;

    @NotBlank
    @JsonProperty("budget_amount")
    private Long budgetAmount;

    @NotBlank
    @JsonProperty("user_id")
    private String userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(Long budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
