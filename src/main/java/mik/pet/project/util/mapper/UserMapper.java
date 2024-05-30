package mik.pet.project.util.mapper;

import mik.pet.project.configuration.MapperConfig;
import mik.pet.project.model.User;
import mik.pet.project.model.dto.request.UserRegistrationDto;
import mik.pet.project.model.dto.response.UserDto;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserDto toDto(User user);

    User toModel(UserRegistrationDto userRegistrationDto);
}
