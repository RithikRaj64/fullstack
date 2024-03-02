package com.educonnect.rithikraj.enumerated;

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
        USER_DELETE
    )),
    STUDENT(Set.of(
        USER_CREATE,
        USER_READ,
        USER_UPDATE,
        USER_DELETE
    )),
    INSTITUTE(Set.of(
        USER_CREATE,
        USER_READ,
        USER_UPDATE,
        USER_DELETE
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
