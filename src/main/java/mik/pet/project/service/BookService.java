package mik.pet.project.service;

import java.util.List;
import mik.pet.project.model.dto.BookDto;
import mik.pet.project.model.dto.NewBookRequestDto;

public interface BookService {
    List<BookDto> findAll();

    BookDto createBook(NewBookRequestDto newBookRequestDto);

    BookDto getBookById(Long id);

    BookDto updateBook(Long id, NewBookRequestDto newBookRequestDto);

    void deleteById(Long id);
}
