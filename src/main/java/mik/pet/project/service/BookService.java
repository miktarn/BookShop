package mik.pet.project.service;

import java.util.List;
import mik.pet.project.dto.request.NewBookRequestDto;
import mik.pet.project.dto.response.BookResponseDto;
import org.springframework.data.domain.Pageable;

public interface BookService {
    List<BookResponseDto> findAll(Pageable pageable);

    BookResponseDto createBook(NewBookRequestDto newBookRequestDto);

    BookResponseDto getBookById(Long id);

    BookResponseDto updateBook(Long id, NewBookRequestDto newBookRequestDto);

    void deleteById(Long id);
}
