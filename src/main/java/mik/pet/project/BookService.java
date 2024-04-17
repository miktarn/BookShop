package mik.pet.project;

import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
