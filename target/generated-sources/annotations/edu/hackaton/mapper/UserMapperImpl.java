package edu.hackaton.mapper;

import edu.hackaton.model.dto.request.UserRequestDTO;
import edu.hackaton.model.dto.response.UserResponseDTO;
import edu.hackaton.model.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-04T17:07:53-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.9 (Arch Linux)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( dto.getId() );
        user.name( dto.getName() );
        user.email( dto.getEmail() );
        user.password( dto.getPassword() );

        return user.build();
    }

    @Override
    public UserResponseDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserResponseDTO.UserResponseDTOBuilder userResponseDTO = UserResponseDTO.builder();

        userResponseDTO.id( entity.getId() );
        userResponseDTO.name( entity.getName() );
        userResponseDTO.email( entity.getEmail() );
        userResponseDTO.password( entity.getPassword() );

        return userResponseDTO.build();
    }
}
