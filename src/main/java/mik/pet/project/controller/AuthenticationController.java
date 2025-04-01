package mik.pet.project.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mik.pet.project.dto.request.UserRegistrationDto;
import mik.pet.project.dto.response.UserResponseDto;
import mik.pet.project.exception.RegistrationException;
import mik.pet.project.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService userService;

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid
                                    UserRegistrationDto request) throws RegistrationException {
        return userService.register(request);
    }
}
