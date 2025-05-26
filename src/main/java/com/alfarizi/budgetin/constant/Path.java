package com.alfarizi.budgetin.constant;

public class Path {
    public static final String BASE_API_PATH = "/api";
    public static final String PRIVATE_API_PATH = BASE_API_PATH + "/private";

    public static final String AUTH_PATH = BASE_API_PATH + "/auth";
    public static final String CATEGORY_PATH = PRIVATE_API_PATH + "/category";
    public static final String TRANSACTION_PATH = PRIVATE_API_PATH + "/transaction";

    public static final String ID = "/{id}";
    public static final String LOGIN = "/login";
    public static final String REGISTER = "/register";
}
