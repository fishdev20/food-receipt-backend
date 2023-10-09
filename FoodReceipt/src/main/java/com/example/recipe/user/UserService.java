package com.example.recipe.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow();
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }
}
