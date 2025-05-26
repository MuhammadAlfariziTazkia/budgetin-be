package com.alfarizi.budgetin.dto;

public class BaseResponseDto {

    String message;
    Object data;

    public BaseResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public BaseResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
