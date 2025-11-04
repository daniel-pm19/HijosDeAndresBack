package edu.hackaton.service;

import org.springframework.stereotype.Service;

import edu.hackaton.mapper.UserMapper;
import edu.hackaton.model.dto.request.UserRequestDTO;
import edu.hackaton.model.dto.response.UserResponseDTO;
import edu.hackaton.model.entity.User;
import edu.hackaton.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserResponseDTO createUser(UserRequestDTO dto){
        User user = userMapper.toEntity(dto);

        User saved = userRepository.save(user);

        return userMapper.toDto(saved);
    }


    public void deleteUser(String id){

        userRepository.deleteById(id);
    }

}
