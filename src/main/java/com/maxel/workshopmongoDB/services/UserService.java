package com.maxel.workshopmongoDB.services;

import com.maxel.workshopmongoDB.domain.User;
import com.maxel.workshopmongoDB.dto.UserDTO;
import com.maxel.workshopmongoDB.repositories.UserRepository;
import com.maxel.workshopmongoDB.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return  user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public User insert(UserDTO user) {
       return userRepository.save(fromDTO(user));
    }

    private User fromDTO(UserDTO userDTO) {
        return new User(null, userDTO.getName(), userDTO.getEmail());
    }
}
