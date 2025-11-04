package edu.hackaton.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hackaton.service.AuthService;
import jakarta.validation.Valid;
import edu.hackaton.model.dto.request.AuthRequestDTO;
import edu.hackaton.model.dto.request.RegisterRequestDTO;
import edu.hackaton.model.dto.response.AuthResponseDTO;
import edu.hackaton.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController{

    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

}
