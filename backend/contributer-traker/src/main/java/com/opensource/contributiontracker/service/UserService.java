package com.opensource.contributiontracker.service;

import com.opensource.contributiontracker.dto.UserRequest;
import com.opensource.contributiontracker.dto.UserResponse;
import com.opensource.contributiontracker.entity.User;
import com.opensource.contributiontracker.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.opensource.contributiontracker.exception.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return convertToResponse(user);
    }

    public UserResponse createUser(UserRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(
                passwordEncoder.encode(request.getPassword()));
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        return convertToResponse(savedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserResponse convertToResponse(User user) {
        return new UserResponse(
                user.getId(), user.getUsername(),
                user.getEmail(),
                user.getCreatedAt());
    }

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
}