package pl.studio.library.controllers.service;

import org.springframework.stereotype.Service;
import pl.studio.library.controllers.service.model.Book;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService{

    private final Book mockedBook = new Book("id", "name", "author");

    @Override
    public Book getBook(String id) {
        return mockedBook;
    }

    @Override
    public List<Book> getBooks() {
        return List.of(mockedBook);
    }

    @Override
    public Book addBook(Book book) {
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        return book;
    }

    @Override
    public void removeBook(String id) {
        //noop
    }
}
