package com.mylooserproject.joy.LooserProject.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class LoginDto {

    @Email
    private String email;
    @Max(1)
    private String loginId;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String password;
}
