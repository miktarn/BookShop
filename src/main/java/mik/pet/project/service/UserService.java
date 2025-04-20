package mik.pet.project.service;

import mik.pet.project.dto.request.UserRegistrationDto;
import mik.pet.project.dto.response.UserResponseDto;
import mik.pet.project.exception.RegistrationException;

public interface UserService {

    UserResponseDto register(UserRegistrationDto request) throws RegistrationException;
}
