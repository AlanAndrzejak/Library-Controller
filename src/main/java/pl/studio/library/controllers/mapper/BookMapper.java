package pl.studio.library.controllers.mapper;

import pl.studio.library.controllers.web.model.Book;

public class BookMapper {
    private BookMapper() {
    }

    public static Book mapServiceBookToWebBook(pl.studio.library.controllers.service.model.Book serviceBook) {
        return new Book(serviceBook.id(), serviceBook.name(), serviceBook.author());
    }

    public static pl.studio.library.controllers.service.model.Book mapWebBookToServiceBook(Book serviceBook) {
        return new pl.studio.library.controllers.service.model.Book(serviceBook.id(), serviceBook.name(), serviceBook.author());
    }
}
