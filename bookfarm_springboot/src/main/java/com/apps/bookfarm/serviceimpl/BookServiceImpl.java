package com.apps.bookfarm.serviceimpl;

import com.apps.bookfarm.model.Book;
import com.apps.bookfarm.repository.BookRepository;
import com.apps.bookfarm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookReository;


    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookReository = bookRepository;
    }

    @Override
    public Iterable<Book> getBook(){
        return bookReository.findAll();
    }

    @Override
    public void addBook(Book book){
        List<Book> optionalBook = bookReository.findByTitle(book.getTitle());
        if (!optionalBook.isEmpty()){
            throw new IllegalStateException("Book Already Exists!!");
        }
        else {
            bookReository.save(book);
        }
    }

    @Override
    public Book update(Book book){
        return bookReository.save(book);
    }

    @Override
    public  void removeBook (Long Id){

    }
}