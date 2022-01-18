package com.maxel.workshopmongoDB.services;

import com.maxel.workshopmongoDB.domain.User;
import com.maxel.workshopmongoDB.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
