package com.alfarizi.budgetin.model;

import com.alfarizi.budgetin.service.intr.CategoryService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @JsonProperty("budget_amount")
    @Column(nullable = false, name = "budget_amount")
    private Long budgetAmount;

    @JsonIgnore
    @Column(nullable = false, name = "user_id")
    private UUID userId;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Transaction> transactions;

    @Transient
    @JsonProperty("remaining_amount")
    private Long remainingAmount;

    public Category (UUID id) {
        this.id = id;
    }

    public Category () {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Long getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Long remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public Category(UUID id, String name, Long budgetAmount, Long remainingAmount) {
        this.id = id;
        this.name = name;
        this.budgetAmount = budgetAmount;
        this.remainingAmount = remainingAmount;
    }
}
