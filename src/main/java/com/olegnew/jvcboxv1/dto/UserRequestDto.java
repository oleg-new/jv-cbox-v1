package com.olegnew.jvcboxv1.dto;

import com.olegnew.jvcboxv1.model.Role;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotBlank
    @Size(min = 2, max = 32)
    private String name;
    @NotBlank
    @Size(min = 2, max = 64)
    private String password;
    private Set<Role> roles;
}
