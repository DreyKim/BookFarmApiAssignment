package com.apps.bookfarm.service;

import com.apps.bookfarm.model.Book;

public interface BookService {

    public Iterable<Book> getBook();

    void addBook(Book book);

    public Book update(Book book);

    void removeBook(Long Id);
}
