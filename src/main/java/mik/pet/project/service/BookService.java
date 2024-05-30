package mik.pet.project.service;

import java.util.List;
import mik.pet.project.model.dto.request.NewBookDto;
import mik.pet.project.model.dto.response.BookDto;
import org.springframework.data.domain.Pageable;

public interface BookService {
    List<BookDto> findAll(Pageable pageable);

    BookDto createBook(NewBookDto newBookDto);

    BookDto getBookById(Long id);

    BookDto updateBook(Long id, NewBookDto newBookDto);

    void deleteById(Long id);
}
