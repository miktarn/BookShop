package mik.pet.project.service;

import mik.pet.project.exception.RegistrationException;
import mik.pet.project.model.dto.request.UserRegistrationDto;
import mik.pet.project.model.dto.response.UserDto;

public interface UserService {

    UserDto register(UserRegistrationDto request) throws RegistrationException;
}
