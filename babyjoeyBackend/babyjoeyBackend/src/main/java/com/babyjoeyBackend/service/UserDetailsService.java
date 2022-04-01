package com.babyjoeyBackend.service;
import com.babyjoeyBackend.repository.UserRepository;
import com.babyjoeyBackend.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = repository.findByUsername(username);



        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return (UserDetails) user;

    }

}
