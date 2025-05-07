package itacademy.mascota.controller;

import itacademy.mascota.model.User;
import itacademy.mascota.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.List;

    @RestController
    @RequestMapping("/api/users")
    public class UserController {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @GetMapping
        public ResponseEntity<List<User>> getAllUsers() {
            List<User> users = userRepository.findAll();
            return ResponseEntity.ok(users);
        }

        @GetMapping("/{username}")
        public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
            return userRepository.findByUsername(username)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping("/register")
        public ResponseEntity<User> registerUser(@RequestBody User user) {

            if (userRepository.findByUsername(user.getUsername()).isPresent()) {
                return ResponseEntity.badRequest().build();           }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User savedUser = userRepository.save(user);

            return ResponseEntity.ok(savedUser);
        }

        @PutMapping("/{username}")
        public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User userDetails) {
            return userRepository.findByUsername(username)
                    .map(user -> {
                        user.setUsername(userDetails.getUsername());
                        user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
                        user.setRoles(userDetails.getRoles());
                        User updatedUser = userRepository.save(user);
                        return ResponseEntity.ok(updatedUser);
                    })
                    .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{username}")
        public ResponseEntity<Void> deleteUser(@PathVariable String username) {
            return userRepository.findByUsername(username)
                    .map(user -> {
                        userRepository.delete(user);
                        return ResponseEntity.ok().<Void>build();
                    })
                    .orElse(ResponseEntity.notFound().build());
        }
    }
