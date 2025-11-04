package edu.hackaton.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import edu.hackaton.model.dto.request.ImageRequestDTO;
import edu.hackaton.model.dto.response.ImageResponseDTO;
import edu.hackaton.model.entity.Image;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    
    Image toEntity(ImageRequestDTO dto);
    ImageResponseDTO toDto(Image image);
    List<ImageResponseDTO> toDtoList(List<Image> dto);
    List<Image> toEntityList(List<ImageRequestDTO> dto);

}
