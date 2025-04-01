package mik.pet.project.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import mik.pet.project.dto.request.NewBookRequestDto;
import mik.pet.project.dto.response.BookResponseDto;
import mik.pet.project.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    @GetMapping
    public List<BookResponseDto> getAll(Pageable pageable) {
        return bookService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public BookResponseDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public BookResponseDto createBook(@RequestBody @Valid NewBookRequestDto newBookRequestDto) {
        return bookService.createBook(newBookRequestDto);
    }

    @PutMapping("/{id}")
    public BookResponseDto updateBook(@PathVariable Long id,
                                      @RequestBody @Valid NewBookRequestDto updateBookDto) {
        return bookService.updateBook(id, updateBookDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
