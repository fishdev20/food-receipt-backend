package com.example.recipe.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/users")

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        User user = userRepository.findById(id).orElseThrow();
        if (user != null) {
            UserDTO userDTO = new UserDTO(user.getId(), user.getFirstname(), user.getLastname(), user.getEmail(),
                    user.getRole());
            log.info(userDTO.toString());
            return ResponseEntity.ok(userDTO);

        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
