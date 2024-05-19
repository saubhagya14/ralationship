package com.example.demo.controller.MyController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    BookPublisherService service;

    @GetMapping("/all")
    public List<Book> all() {
        return service.findAllBook();
    }

    @GetMapping("/bookName/{bookname}")
    public List<Book> findBook(@PathVariable("bookname") String bookName) {
        return service.findBook(bookName);
    }

}
