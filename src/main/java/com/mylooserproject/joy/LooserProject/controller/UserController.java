package com.mylooserproject.joy.LooserProject.controller;

import com.mylooserproject.joy.LooserProject.dto.LoginDto;
import com.mylooserproject.joy.LooserProject.dto.SignInResponse;
import com.mylooserproject.joy.LooserProject.dto.SignUpDto;
import com.mylooserproject.joy.LooserProject.entity.User;
import com.mylooserproject.joy.LooserProject.security.service.MyUserDetailsService;
import com.mylooserproject.joy.LooserProject.service.UserService;
import com.mylooserproject.joy.LooserProject.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Api("Operations about User")
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    MyUserDetailsService myUserDetailsService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/signup")
    @ApiOperation(value = "Register New User")
    public ResponseEntity<User> signUp(@RequestBody SignUpDto signUpDto) {
        User user = userService.signUp(signUpDto);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/login")
    @ApiOperation(value = "Login User to the System")
    public ResponseEntity<?> logIn(@Valid @RequestBody LoginDto loginDto) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
            );
        }
        catch (BadCredentialsException ex)
        {
            throw new Exception("Invalid UserName and Password "+ex);
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginDto.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok().body(new SignInResponse(jwt));
    }

    @RequestMapping(path = "/admin")
    public String admin() {
        return "<h1>Welcome Admin</h1>";
    }

    @RequestMapping(path = "/user")
    public String user() {
        return "<h1>Welcome User</h1>";
    }

}
