package com.mylooserproject.joy.LooserProject.service;

import com.mylooserproject.joy.LooserProject.dto.LoginDto;
import com.mylooserproject.joy.LooserProject.dto.SignUpDto;
import com.mylooserproject.joy.LooserProject.entity.User;

public interface UserService {
    User signUp(SignUpDto signUpDto);
    User login(LoginDto loginDto);
    User userDetails(String email);
}
