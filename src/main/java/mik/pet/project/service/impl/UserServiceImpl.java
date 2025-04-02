package mik.pet.project.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mik.pet.project.dto.request.UserRegistrationDto;
import mik.pet.project.dto.response.UserResponseDto;
import mik.pet.project.exception.RegistrationException;
import mik.pet.project.model.User;
import mik.pet.project.repository.UserRepository;
import mik.pet.project.service.UserService;
import mik.pet.project.util.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserResponseDto register(UserRegistrationDto newUserDto) throws RegistrationException {
        if (userRepository.existsUserByEmail(newUserDto.getEmail())) {
            throw new RegistrationException("User with email %s already exists"
                    .formatted(newUserDto.getEmail()));
        }
        User savedUser = userRepository.save(userMapper.toModel(newUserDto));
        return userMapper.toDto(savedUser);
    }
}
