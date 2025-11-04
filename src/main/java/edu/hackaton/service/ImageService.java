package edu.hackaton.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.hackaton.mapper.ImageMapper;
import edu.hackaton.model.dto.request.ImageRequestDTO;
import edu.hackaton.model.dto.response.ImageResponseDTO;
import edu.hackaton.model.entity.Image;
import edu.hackaton.repository.ImageRepository;
import edu.hackaton.service.AiService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {
    
    private final ImageRepository imageRepository;

    private final ImageMapper imageMapper;

    private final AiService aiService;

    public ImageResponseDTO createImage(ImageRequestDTO dto){
        Image image = imageMapper.toEntity(dto);

        Image saved = imageRepository.save(image);

        return imageMapper.toDto(saved);
    }

    public void deleteImage(String id){
        imageRepository.deleteById(id);
    }

    public List<ImageResponseDTO> getImageResponseByUserId(String userId){
        
        List<Image> images = imageRepository.findByUserId(userId);

        return imageMapper.toDtoList(images);
    

    }

    public ImageResponseDTO analyzeAndSave(ImageRequestDTO request) {
       
        String description = aiService.analyzeImage(request.getImageUrl());

        Image doc = Image.builder()
                .userId(request.getUserId())
                .imageUrl(request.getImageUrl())
                .description(description)
                .createdAt(LocalDateTime.now())
                .build();

        Image saved = imageRepository.save(doc);

        return ImageResponseDTO.builder()
                .id(saved.getId())
                .userId(saved.getUserId())
                .imageUrl(saved.getImageUrl())
                .description(saved.getDescription())
                .createdAt(saved.getCreatedAt())
                .build();
    }

}
