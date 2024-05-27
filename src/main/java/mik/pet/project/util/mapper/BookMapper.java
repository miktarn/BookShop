package mik.pet.project.util.mapper;

import mik.pet.project.configuration.MapperConfig;
import mik.pet.project.model.Book;
import mik.pet.project.model.dto.BookDto;
import mik.pet.project.model.dto.NewBookRequestDto;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(NewBookRequestDto newBookRequestDto);
}
