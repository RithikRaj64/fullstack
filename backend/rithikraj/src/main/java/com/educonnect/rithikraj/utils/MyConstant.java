package com.educonnect.rithikraj.utils;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.Arrays;

public class MyConstant {
    // User Controller
    public static final String USER = "/api/v1/user";
    
    // Student Controller
    public static final String STUDENT = "/api/v1/student";

    // Institute Controller
    public static final String INSTITUTE = "/api/v1/institute";

    // Course Controller
    public static final String COURSE = "/api/v1/course";

    // Application Controller
    public static final String APPLICATION = "/api/v1/application";

    // Transaction Controller
    public static final String TRANSACTION = "/api/v1/transaction";
    
    // Admin Controller
    public static final String AUTH = "/api/v1/auth";

    // Auth Endpoints
    public static final String REGISTER = "/register";
    public static final String SIGNIN = "/signin";

    // General Endpoints
    public static final String ADD = "/add";
    public static final String GET = "/get";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    public static final String UPDATE_PASSWORD = "/update/password";


    // Web Security
    public static final List<String> ORIGINS = Arrays.asList("http://localhost:4000", "http://localhost:5713");
    public static final List<String> HEADERS = Arrays.asList(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE);
    public static final List<String> METHODS = Arrays.asList(HttpMethod.GET.name(), 
                                                                HttpMethod.POST.name(), HttpMethod.PUT.name(), 
                                                                HttpMethod.DELETE.name(), HttpMethod.PATCH.name(), 
                                                                HttpMethod.HEAD.name(), HttpMethod.OPTIONS.name());
    public static final String[] WHITELIST = {
        "/api/v1/auth/**"
    };
}
