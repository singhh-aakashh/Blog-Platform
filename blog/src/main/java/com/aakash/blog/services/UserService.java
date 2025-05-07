package com.aakash.blog.services;

import com.aakash.blog.domain.entities.User;

import java.util.UUID;

public interface UserService {

    User getUserById(UUID id);
}
