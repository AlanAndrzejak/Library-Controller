package pl.studio.library.controllers.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.studio.library.controllers.mapper.BookMapper;
import pl.studio.library.controllers.service.LibraryService;
import pl.studio.library.controllers.web.model.Book;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable String id) {
        var serviceBook = libraryService.getBook(id);
        return BookMapper.mapServiceBookToWebBook(serviceBook);
    }

    @GetMapping("/books/")
    public List<Book> getBooks() {
        var serviceBooks = libraryService.getBooks();
        return serviceBooks.stream().map(BookMapper::mapServiceBookToWebBook).toList();
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        var serviceBook = libraryService.addBook(BookMapper.mapWebBookToServiceBook(book));
        return BookMapper.mapServiceBookToWebBook(serviceBook);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book book) {
        var serviceBook = libraryService.getBook(id);
        if(serviceBook == null){
            return ResponseEntity.notFound().build();
        }
        var updatedServiceBook = libraryService.updateBook(BookMapper.mapWebBookToServiceBook(book));
        return ResponseEntity.ok(BookMapper.mapServiceBookToWebBook(updatedServiceBook));
    }

    @DeleteMapping("/book/{id}")
    public void removeBook(@PathVariable String id) {
        libraryService.removeBook(id);
    }

}
