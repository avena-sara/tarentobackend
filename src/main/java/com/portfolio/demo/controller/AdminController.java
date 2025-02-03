package com.portfolio.demo.controller;

import com.portfolio.demo.model.AppUser;
import com.portfolio.demo.repository.AppUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/admin")
public class AdminController {

    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminController(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/app_users")
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/app_users")
    public ResponseEntity<String> createUser(@RequestBody AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
        userRepository.save(user);
        return ResponseEntity.ok("User created successfully");
    }

    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody AppUser loginRequest) {
        Optional<AppUser> userOptional = userRepository.findByUsername(loginRequest.getUsername());

        if (userOptional.isPresent()) {
            AppUser user = userOptional.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return ResponseEntity.ok("Login successful");
            }
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }

    // Delete User Endpoint (assuming ID is Long)
    @DeleteMapping("/app_users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        }
        return ResponseEntity.status(404).body("User not found");
    }
}
