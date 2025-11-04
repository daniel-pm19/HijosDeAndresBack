package edu.hackaton.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import edu.hackaton.model.dto.request.AuthRequestDTO;
import edu.hackaton.model.dto.request.RegisterRequestDTO;
import edu.hackaton.model.dto.request.UserRequestDTO;
import edu.hackaton.model.dto.response.AuthResponseDTO;
import edu.hackaton.model.dto.response.UserResponseDTO;
import edu.hackaton.model.entity.User;
import edu.hackaton.repository.UserRepository;
import edu.hackaton.security.JwtUtil;
import edu.hackaton.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    public AuthResponseDTO login(AuthRequestDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        
        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponseDTO(token);
    }

}
