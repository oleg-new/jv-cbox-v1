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
    private String password;
    @NotBlank
    private Set<Role> roles;
}
