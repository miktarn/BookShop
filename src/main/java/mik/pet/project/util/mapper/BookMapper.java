package mik.pet.project.util.mapper;

import mik.pet.project.configuration.MapperConfig;
import mik.pet.project.dto.request.NewBookRequestDto;
import mik.pet.project.dto.response.BookResponseDto;
import mik.pet.project.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookResponseDto toDto(Book book);

    Book toModel(NewBookRequestDto newBookRequestDto);
}
