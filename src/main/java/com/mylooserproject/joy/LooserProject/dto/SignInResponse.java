package com.mylooserproject.joy.LooserProject.dto;

public class SignInResponse {
    private final String jwt;

    public SignInResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
