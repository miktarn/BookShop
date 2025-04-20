package mik.pet.project.util.mapper;

import mik.pet.project.configuration.MapperConfig;
import mik.pet.project.dto.request.UserRegistrationDto;
import mik.pet.project.dto.response.UserResponseDto;
import mik.pet.project.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);

    User toModel(UserRegistrationDto userRegistrationDto);
}
