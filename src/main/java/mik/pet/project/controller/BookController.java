package mik.pet.project.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import mik.pet.project.exception.EntityNotFoundException;
import mik.pet.project.model.dto.BookDto;
import mik.pet.project.model.dto.CreateBookRequestDto;
import mik.pet.project.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    @GetMapping()
    public List<BookDto> getAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) throws EntityNotFoundException {
        return bookService.getBookById(id);
    }

    @PostMapping()
    public BookDto createBook(@RequestBody CreateBookRequestDto createBookRequestDto) {
        return bookService.createBook(createBookRequestDto);
    }
}
