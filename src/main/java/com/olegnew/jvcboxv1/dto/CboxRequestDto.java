package com.olegnew.jvcboxv1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CboxRequestDto {
    @NotBlank
    @Size(min = 2)
    private String street;
    @NotBlank
    @Size(min = 1)
    private String house;
    @NotBlank
    @Size(min = 7)
    @Pattern(regexp = "^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$")
    private String ipAddress;
}
