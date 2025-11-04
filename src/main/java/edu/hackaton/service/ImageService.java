package edu.hackaton.service;

import org.springframework.stereotype.Service;

import edu.hackaton.mapper.ImageMapper;
import edu.hackaton.model.dto.request.ImageRequestDTO;
import edu.hackaton.model.dto.response.ImageResponseDTO;
import edu.hackaton.model.entity.Image;
import edu.hackaton.repository.ImageRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {
    
    private final ImageRepository imageRepository;

    private final ImageMapper imageMapper;

    public ImageResponseDTO createImage(ImageRequestDTO dto){
        Image image = imageMapper.toEntity(dto);

        Image saved = imageRepository.save(image);

        return imageMapper.toDto(saved);
    }

    public void deleteImage(String id){
        imageRepository.deleteById(id);
    }


}
