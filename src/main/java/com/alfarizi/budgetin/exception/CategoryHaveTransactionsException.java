package com.alfarizi.budgetin.exception;

import java.util.UUID;

public class CategoryHaveTransactionsException extends Exception {

    UUID id;

    public CategoryHaveTransactionsException(UUID id) {
        super(String.format("Category:%s have transactions", id.toString()));
    }
}
