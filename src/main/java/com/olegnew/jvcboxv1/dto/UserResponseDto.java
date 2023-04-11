package com.olegnew.jvcboxv1.dto;

import com.olegnew.jvcboxv1.model.Role;
import java.util.Set;
import lombok.Data;

@Data
public class UserResponseDto {
    private String id;
    private String name;
    private Set<Role> roles;
}
