package mik.pet.project.service.impl;

import jakarta.transaction.Transactional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import mik.pet.project.dto.request.UserRegistrationDto;
import mik.pet.project.dto.response.UserResponseDto;
import mik.pet.project.exception.RegistrationException;
import mik.pet.project.model.Role;
import mik.pet.project.model.User;
import mik.pet.project.repository.RoleRepository;
import mik.pet.project.repository.UserRepository;
import mik.pet.project.service.UserService;
import mik.pet.project.util.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponseDto register(UserRegistrationDto newUserDto) throws RegistrationException {
        if (userRepository.existsUserByEmail(newUserDto.getEmail())) {
            throw new RegistrationException("User with email %s already exists"
                    .formatted(newUserDto.getEmail()));
        }
        Role userRole = roleRepository.findByName(Role.RoleName.ROLE_USER)
                .orElseThrow(() -> new IllegalStateException("Enable to find RoleUser in DB"));

        User mappedUser = userMapper.toModel(newUserDto);
        mappedUser.setRoles(Set.of(userRole));
        mappedUser.setPassword(passwordEncoder.encode(mappedUser.getPassword()));
        User savedUser = userRepository.save(mappedUser);
        return userMapper.toDto(savedUser);
    }
}
