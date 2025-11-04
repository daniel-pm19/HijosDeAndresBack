package edu.hackaton.mapper;

import org.mapstruct.Mapper;

import edu.hackaton.model.dto.request.UserRequestDTO;
import edu.hackaton.model.dto.response.UserResponseDTO;
import edu.hackaton.model.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    User toEntity(UserRequestDTO dto);

    UserResponseDTO toDto(User entity);

}
