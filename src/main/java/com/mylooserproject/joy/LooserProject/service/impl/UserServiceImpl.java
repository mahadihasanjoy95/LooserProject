package com.mylooserproject.joy.LooserProject.service.impl;

import com.mylooserproject.joy.LooserProject.dto.LoginDto;
import com.mylooserproject.joy.LooserProject.dto.SignUpDto;
import com.mylooserproject.joy.LooserProject.entity.User;
import com.mylooserproject.joy.LooserProject.repository.UserRepository;
import com.mylooserproject.joy.LooserProject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     *
     * @param signUpDto
     * @return
     */
    @Override
    public User signUp(SignUpDto signUpDto) {
        return userRepository.save(prepareUser(signUpDto));
    }

    User prepareUser(SignUpDto signUpDto){
        User user = new User();
        user.setEmail(signUpDto.getEmail());
        user.setAge(signUpDto.getAge());
        user.setFirstName(signUpDto.getFirstName());
        user.setLastName(signUpDto.getLastName());
        user.setLoginId(signUpDto.getLoginId());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        return user;
    }

    @Override
    public User login(LoginDto loginDto) {
        return null;
    }
    @Override
    public User userDetails(String email) {
        User user = userRepository.findUserByEmail(email);
        return user;
    }

}
