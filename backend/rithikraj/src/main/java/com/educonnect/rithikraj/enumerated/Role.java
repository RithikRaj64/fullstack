package com.educonnect.rithikraj.enumerated;

import static com.educonnect.rithikraj.enumerated.Permission.APPLICATION_CREATE;
import static com.educonnect.rithikraj.enumerated.Permission.APPLICATION_DELETE;
import static com.educonnect.rithikraj.enumerated.Permission.APPLICATION_READ;
import static com.educonnect.rithikraj.enumerated.Permission.APPLICATION_UPDATE;
import static com.educonnect.rithikraj.enumerated.Permission.COURSE_CREATE;
import static com.educonnect.rithikraj.enumerated.Permission.COURSE_DELETE;
import static com.educonnect.rithikraj.enumerated.Permission.COURSE_READ;
import static com.educonnect.rithikraj.enumerated.Permission.COURSE_UPDATE;
import static com.educonnect.rithikraj.enumerated.Permission.INSTITUTE_CREATE;
import static com.educonnect.rithikraj.enumerated.Permission.INSTITUTE_DELETE;
import static com.educonnect.rithikraj.enumerated.Permission.INSTITUTE_READ;
import static com.educonnect.rithikraj.enumerated.Permission.INSTITUTE_UPDATE;
import static com.educonnect.rithikraj.enumerated.Permission.STUDENT_CREATE;
import static com.educonnect.rithikraj.enumerated.Permission.STUDENT_DELETE;
import static com.educonnect.rithikraj.enumerated.Permission.STUDENT_READ;
import static com.educonnect.rithikraj.enumerated.Permission.STUDENT_UPDATE;
import static com.educonnect.rithikraj.enumerated.Permission.TRANSACTION_CREATE;
import static com.educonnect.rithikraj.enumerated.Permission.TRANSACTION_DELETE;
import static com.educonnect.rithikraj.enumerated.Permission.TRANSACTION_READ;
import static com.educonnect.rithikraj.enumerated.Permission.USER_CREATE;
import static com.educonnect.rithikraj.enumerated.Permission.USER_DELETE;
import static com.educonnect.rithikraj.enumerated.Permission.USER_READ;
import static com.educonnect.rithikraj.enumerated.Permission.USER_UPDATE;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    ADMIN(Set.of(
        USER_READ,
        USER_CREATE,
        USER_UPDATE,
        USER_DELETE,
        STUDENT_CREATE,
        STUDENT_READ,
        STUDENT_DELETE,
        INSTITUTE_CREATE,
        INSTITUTE_READ,
        INSTITUTE_DELETE,
        APPLICATION_READ,
        APPLICATION_DELETE,
        COURSE_READ,
        COURSE_DELETE,
        TRANSACTION_READ
    )),
    STUDENT(Set.of(
        USER_CREATE,
        USER_READ,
        USER_UPDATE,
        USER_DELETE,
        STUDENT_CREATE,
        STUDENT_READ,
        STUDENT_UPDATE,
        STUDENT_DELETE,
        COURSE_READ,
        COURSE_UPDATE,
        INSTITUTE_READ,
        APPLICATION_CREATE,
        APPLICATION_READ,
        APPLICATION_DELETE,
        APPLICATION_UPDATE,
        TRANSACTION_CREATE,
        TRANSACTION_READ,
        TRANSACTION_DELETE
    )),
    INSTITUTE(Set.of(
        USER_CREATE,
        USER_READ,
        USER_UPDATE,
        USER_DELETE,
        STUDENT_READ,
        TRANSACTION_READ,
        APPLICATION_READ,
        APPLICATION_UPDATE,
        COURSE_CREATE,
        COURSE_READ,
        COURSE_UPDATE,
        COURSE_DELETE,
        INSTITUTE_CREATE,
        INSTITUTE_READ,
        INSTITUTE_UPDATE,
        INSTITUTE_DELETE
    ));

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions().stream()
                            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                            .collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        
        return authorities;
    }
}
