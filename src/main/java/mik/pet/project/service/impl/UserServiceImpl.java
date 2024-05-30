package mik.pet.project.service.impl;

import lombok.AllArgsConstructor;
import mik.pet.project.exception.RegistrationException;
import mik.pet.project.model.User;
import mik.pet.project.model.dto.request.UserRegistrationDto;
import mik.pet.project.model.dto.response.UserDto;
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
    public UserDto register(UserRegistrationDto newUserDto) throws RegistrationException {
        if (userRepository.existsUserByEmail(newUserDto.getEmail())) {
            throw new RegistrationException("User with email" + newUserDto.getEmail()
                    + "already exists");
        }
        User savedUser = userRepository.save(userMapper.toModel(newUserDto));
        return userMapper.toDto(savedUser);
    }
}
