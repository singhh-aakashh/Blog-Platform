package com.aakash.blog.controller;

import com.aakash.blog.domain.dtos.AuthResponse;
import com.aakash.blog.domain.dtos.LoginRequest;
import com.aakash.blog.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth/login")
@RequiredArgsConstructor
public class AuthControllers {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
       UserDetails userDetails =  authenticationService.authenticate(loginRequest.getEmail(),loginRequest.getPassword());

      String tokenValue =  authenticationService.generateToken(userDetails);

      return new ResponseEntity<>(AuthResponse.builder().token(tokenValue).expiresIn(86400).build(), HttpStatus.OK);
    }
}
