package pl.studio.library.controllers.service;

import pl.studio.library.controllers.service.model.Book;

import java.util.List;

public interface LibraryService {

    Book getBook(String id);

    List<Book> getBooks();

    Book addBook(Book book);

    Book updateBook(Book book);

    void removeBook(String id);

}
