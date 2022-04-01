package com.babyjoeyBackend.service;
import com.babyjoeyBackend.entity.UserEntity;
import com.babyjoeyBackend.exeption.NotFoundExeption;
import com.babyjoeyBackend.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.List;
import java.util.Optional;
@Service

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users;
    }
    @SneakyThrows
    public UserEntity getUserByID(long id) {
        UserEntity user =  userRepository.findById((int) id)
                .orElseThrow(() -> new NotFoundExeption("user not found"+id));

        return  user;
    }
    @Override
    public UserEntity addUser(UserEntity user) {
        user.setUsername(user.getUsername());
        // user.setPassword(encoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(UserEntity updateuser, long id) {
        UserEntity user = userRepository.findById((int) id)
                .orElseThrow(()-> new NotAcceptableStatusException("user not found"));
        user.setId(updateuser.getId());
        user.setUsername(updateuser.getUsername());
        user.setPassword(updateuser.getPassword());
        user.setRole(updateuser.getRole());
        user.setPassword(updateuser.getPassword());
        userRepository.save(user);

        return user;
    }
    @Override
    public void deleteUser(long Id) {

        userRepository.deleteById((int) Id);
    }
    @Override
    public Optional<UserEntity> getUserByIdResponse(long id) {
        return userRepository.findById((int) id);
    }


}
