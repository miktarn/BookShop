package mik.pet.project.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mik.pet.project.exception.EntityNotFoundException;
import mik.pet.project.model.Book;
import mik.pet.project.model.dto.BookDto;
import mik.pet.project.model.dto.CreateBookRequestDto;
import mik.pet.project.repository.BookRepository;
import mik.pet.project.util.mapper.BookMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto createBook(CreateBookRequestDto createBookRequestDto) {
        Book createdBook = bookRepository.save(bookMapper.toModel(createBookRequestDto));
        return bookMapper.toDto(createdBook);
    }

    @Override
    public BookDto getBookById(Long id) throws EntityNotFoundException {
        Book pulledBook = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Could not find Book with id " + id)
        );
        return bookMapper.toDto(pulledBook);
    }
}
