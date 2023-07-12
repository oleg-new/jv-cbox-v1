package com.olegnew.jvcboxv1.dto;

import com.olegnew.jvcboxv1.model.Role;
import java.util.Set;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotBlank
    @Size(min = 2, max = 32, message = "Name min = 2, max = 3200")
    /*@Min(value = 15, message = "Age should not be less than 15")
    @Max(value = 65, message = "Age should not be greater than 65")*/
    private String name;
    @NotBlank
    @Size(min = 2, max = 64)
    private String password;
    private Set<Role> roles;
}
