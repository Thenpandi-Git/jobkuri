package com.jobkuri.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.jobkuri.DTO.LoginRequestDTO;
import com.jobkuri.DTO.RegisterRequestDTO;
import com.jobkuri.Entity.User;
import com.jobkuri.Repository.UserRepository;
import com.jobkuri.Security.JWTUtil;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired 
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTUtil jwtUtil;

    public String register(RegisterRequestDTO dto) {
        if (userRepository.existsByName(dto.getName()) || userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword())); // ✅ encoded
        user.setRole(dto.getRole());

        userRepository.save(user);
        return "User registered successfully";
    }

    public String login(LoginRequestDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Email or Password");
        }

        // generate token with username/email instead of full entity (safer)
        return jwtUtil.generateToken(user);
    }
}
