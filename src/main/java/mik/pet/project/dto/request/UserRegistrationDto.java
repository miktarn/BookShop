package mik.pet.project.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mik.pet.project.util.validation.FieldMatch;
import org.hibernate.validator.constraints.Length;

@FieldMatch(first = "password", second = "repeatPassword",
        message = "Passwords should match each other")
@Data
public class UserRegistrationDto {
    @NotNull
    @Email
    private String email;
    @NotBlank
    @Length(min = 8, max = 100)
    private String password;
    @NotBlank
    @Length(min = 8, max = 100)
    private String repeatPassword;
    @NotBlank
    @Length(min = 2, max = 40)
    private String firstName;
    @NotBlank
    @Length(min = 2, max = 40)
    private String lastName;
    @Length(min = 10, max = 500)
    private String shippingAddress;
}
