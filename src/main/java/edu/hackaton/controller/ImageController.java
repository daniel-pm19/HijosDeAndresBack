package edu.hackaton.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hackaton.model.dto.request.ImageRequestDTO;
import edu.hackaton.model.dto.response.ImageResponseDTO;
import edu.hackaton.service.ImageService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/analyze")
    public ResponseEntity<ImageResponseDTO> analyzeImage(@RequestBody ImageRequestDTO request) {
        ImageResponseDTO response = imageService.analyzeAndSave(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ImageResponseDTO>> getImageResponseByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(imageService.getImageResponseByUserId(userId));
    }
}
