package edu.hackaton.mapper;

import edu.hackaton.model.dto.request.ImageRequestDTO;
import edu.hackaton.model.dto.response.ImageResponseDTO;
import edu.hackaton.model.entity.Image;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-04T18:48:44-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.9 (Arch Linux)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    @Override
    public Image toEntity(ImageRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Image.ImageBuilder image = Image.builder();

        image.id( dto.getId() );
        image.userId( dto.getUserId() );
        image.imageUrl( dto.getImageUrl() );
        image.description( dto.getDescription() );
        image.createdAt( dto.getCreatedAt() );

        return image.build();
    }

    @Override
    public ImageResponseDTO toDto(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageResponseDTO.ImageResponseDTOBuilder imageResponseDTO = ImageResponseDTO.builder();

        imageResponseDTO.id( image.getId() );
        imageResponseDTO.userId( image.getUserId() );
        imageResponseDTO.imageUrl( image.getImageUrl() );
        imageResponseDTO.description( image.getDescription() );
        imageResponseDTO.createdAt( image.getCreatedAt() );

        return imageResponseDTO.build();
    }

    @Override
    public List<ImageResponseDTO> toDtoList(List<Image> dto) {
        if ( dto == null ) {
            return null;
        }

        List<ImageResponseDTO> list = new ArrayList<ImageResponseDTO>( dto.size() );
        for ( Image image : dto ) {
            list.add( toDto( image ) );
        }

        return list;
    }

    @Override
    public List<Image> toEntityList(List<ImageRequestDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Image> list = new ArrayList<Image>( dto.size() );
        for ( ImageRequestDTO imageRequestDTO : dto ) {
            list.add( toEntity( imageRequestDTO ) );
        }

        return list;
    }
}
