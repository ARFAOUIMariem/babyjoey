package com.babyjoeyBackend.service;

import com.babyjoeyBackend.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserEntity> getAllUsers();

    UserEntity getUserByID(long id);

    UserEntity addUser(UserEntity user);

    UserEntity updateUser(UserEntity updateuser, long id);

    void deleteUser(long id);

    Optional<UserEntity> getUserByIdResponse(long id);
}