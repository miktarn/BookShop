package mik.pet.project.util.mapper;

import mik.pet.project.configuration.MapperConfig;
import mik.pet.project.model.Book;
import mik.pet.project.model.dto.request.NewBookDto;
import mik.pet.project.model.dto.response.BookDto;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(NewBookDto newBookDto);
}
