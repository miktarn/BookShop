package mik.pet.project.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mik.pet.project.util.validation.FieldMatch;

@FieldMatch(first = "password", second = "repeatPassword",
        message = "Passwords should match each other")
@Data
public class UserRegistrationDto {
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String repeatPassword;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String shippingAddress;
}
