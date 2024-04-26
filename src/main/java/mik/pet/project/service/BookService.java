package mik.pet.project.service;

import java.util.List;
import mik.pet.project.exception.EntityNotFoundException;
import mik.pet.project.model.Book;
import mik.pet.project.model.dto.BookDto;
import mik.pet.project.model.dto.CreateBookRequestDto;

public interface BookService {
    Book save(Book book);

    List<BookDto> findAll();

    BookDto createBook(CreateBookRequestDto createBookRequestDto);

    BookDto getBookById(Long id) throws EntityNotFoundException;
}
