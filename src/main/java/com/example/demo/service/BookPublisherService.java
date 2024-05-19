package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repo.BookREpo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookPublisherService {

    @Autowired
    BookREpo bookREpo;

    public void saveAllBooks(List<Book> books) {
        bookREpo.saveAll(books);
    }

    public List<Book> findAllBook() {
        return bookREpo.findAll();
    }

    public List<Book> findBook(String bookName) {
        return bookREpo.findByBookName(bookName);
    }
}
