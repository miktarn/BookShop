package mik.pet.project.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import mik.pet.project.exception.EntityNotFoundException;
import mik.pet.project.model.dto.BookDto;
import mik.pet.project.model.dto.NewBookRequestDto;
import mik.pet.project.service.BookService;
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
    /**
     * GET: /api/books (retrieve book catalog — should have been done in the last PR);
     * GET: /api/books/{id} (retrieve book details — should have been done in the last PR);
     * POST: /api/books (create a new book — should have been done in the last PR);
     * PUT: /api/books/{id} (update a specific book);
     * DELETE /api/books/{id} (delete a specific book)
     */
    private BookService bookService;

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) throws EntityNotFoundException {
        return bookService.getBookById(id);
    }

    @PostMapping
    public BookDto createBook(@RequestBody NewBookRequestDto newBookRequestDto) {
        return bookService.createBook(newBookRequestDto);
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id, @RequestBody NewBookRequestDto updateBookDto) {
        return bookService.updateBook(id, updateBookDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
