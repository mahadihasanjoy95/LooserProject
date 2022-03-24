package com.mylooserproject.joy.LooserProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String loginId;
    private String password;
}
