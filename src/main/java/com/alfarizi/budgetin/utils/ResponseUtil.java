package com.alfarizi.budgetin.utils;

import com.alfarizi.budgetin.dto.BaseResponseDto;
import com.alfarizi.budgetin.exception.CategoryHaveTransactionsException;
import com.alfarizi.budgetin.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    private static final String SUCCESS = "success";

    public static ResponseEntity<BaseResponseDto> success (Object data) {
        return ResponseEntity.ok(new BaseResponseDto("success", data));
    }

    public static ResponseEntity<BaseResponseDto> success () {
        return ResponseEntity.ok(new BaseResponseDto("success"));
    }

    public static ResponseEntity<BaseResponseDto> notFound (EntityNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new BaseResponseDto(e.getMessage()));
    }

    public static ResponseEntity<BaseResponseDto> unprocessableEntity (CategoryHaveTransactionsException e) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new BaseResponseDto(e.getMessage()));
    }
}
