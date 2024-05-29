package mik.pet.project.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mik.pet.project.exception.EntityNotFoundException;
import mik.pet.project.model.Book;
import mik.pet.project.model.dto.BookDto;
import mik.pet.project.model.dto.NewBookRequestDto;
import mik.pet.project.repository.BookRepository;
import mik.pet.project.util.mapper.BookMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Override
    public List<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto createBook(NewBookRequestDto newBookRequestDto) {
        Book createdBook = bookRepository.save(bookMapper.toModel(newBookRequestDto));
        return bookMapper.toDto(createdBook);
    }

    @Override
    public BookDto getBookById(Long id) {
        Book pulledBook = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Failed to get: Could not find Book with id "
                        + id)
        );
        return bookMapper.toDto(pulledBook);
    }

    @Override
    public BookDto updateBook(Long id, NewBookRequestDto newBookRequestDto) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Failed to update: Could not find Book with id "
                    + id);
        }
        Book book = bookMapper.toModel(newBookRequestDto);
        book.setId(id);
        Book updatedBook = bookRepository.save(book);
        return bookMapper.toDto(updatedBook);
    }

    @Override
    public void deleteById(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Failed to delete: Could not find Book with id "
                    + id);
        }
        bookRepository.deleteById(id);
    }
}
