package com.aakash.blog.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService {

    UserDetails authenticate(String email,String password);

    String generateToken(UserDetails userDetails);

    UserDetails validateToken(String token);
}
