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
    public static final String ACCEPT = "/accept";
    public static final String REJECT = "/reject";

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
    public static final String UPDATE_DETAILS = "/updateDetails";


    // Web Security
    public static final List<String> ORIGINS = Arrays.asList("http://localhost:4000", "http://localhost:5713");
    public static final List<String> HEADERS = Arrays.asList(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE);
    public static final List<String> METHODS = Arrays.asList(HttpMethod.GET.name(), 
                                                                HttpMethod.POST.name(), HttpMethod.PUT.name(), 
                                                                HttpMethod.DELETE.name(), HttpMethod.PATCH.name(), 
                                                                HttpMethod.HEAD.name(), HttpMethod.OPTIONS.name());
    public static final String[] WHITELIST = {
        "/api/v1/auth/**",
        "/swagger-ui/**",
        "/swagger-ui.html/**",
        "/v3/api-docs/**"
    };

    // JWT
    public static final String JWT_LOCALHOST_URL = "http://localhost:8080";
    public static final String JWT_SECURITY_SCHEME_NAME = "bearerAuth";
    public static final String JWT_SCHEME = "bearer";
    public static final String JWT_DESCRIPTION = "Provide the JWT token.";
    public static final String JWT_BEARER_FORMAT = "JWT";

    // Swagger
    public static final String SWAGGER_TITLE = "EduConnect";
    public static final String SWAGGER_DESCRIPTION = "EduConnect - Online College Admission Portal";
    public static final String SWAGGER_VERSION = "1.0";
    public static final String SWAGGER_CONTACT_NAME = "Rithik Raj K S";
    public static final String SWAGGER_CONTACT_URL = "https://www.linkedin.com/in/rithik-raj-k-s-a180ab226";
    public static final String SWAGGER_CONTACT_EMAIL = "rithu0644@gmail.com";
    public static final String SWAGGER_LICENSE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0.html";
}
