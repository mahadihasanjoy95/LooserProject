package com.mylooserproject.joy.LooserProject.security.service;

import com.mylooserproject.joy.LooserProject.security.model.MyUserDetails;
import com.mylooserproject.joy.LooserProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails userDetails =  MyUserDetails.build(userService.userDetails(email));
        return userDetails;
    }
}
