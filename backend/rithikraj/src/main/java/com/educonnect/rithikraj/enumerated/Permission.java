package com.educonnect.rithikraj.enumerated;

import lombok.RequiredArgsConstructor;
import lombok.Getter;

@RequiredArgsConstructor
public enum Permission {
    USER_READ("admin:read"),
    USER_CREATE("admin:create"),
    USER_UPDATE("admin:update"),
    USER_DELETE("admin:delete"),

    STUDENT_READ("student:read"),
    STUDENT_CREATE("student:create"),
    STUDENT_UPDATE("student:update"),
    STUDENT_DELETE("student:delete"),

    INSTITUTE_READ("institute:read"),
    INSTITUTE_CREATE("institute:create"),
    INSTITUTE_UPDATE("institute:update"),
    INSTITUTE_DELETE("institute:delete"),

    COURSE_READ("course:read"),
    COURSE_CREATE("course:create"),
    COURSE_UPDATE("course:update"),
    COURSE_DELETE("course:delete"),

    TRANSACTION_READ("transaction:read"),
    TRANSACTION_CREATE("transaction:create"),
    TRANSACTION_UPDATE("transaction:update"),
    TRANSACTION_DELETE("transaction:delete"),

    APPLICATION_READ("application:read"),
    APPLICATION_CREATE("application:create"),
    APPLICATION_UPDATE("application:update"),
    APPLICATION_DELETE("application:delete");

    @Getter
    private final String Permission;
}
