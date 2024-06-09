package com.example.demo.controller.MyController;

import com.example.demo.entity.*;
import com.example.demo.service.BookPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    BookPublisherService service;

    @GetMapping("/all")
    public CustomeDTO all(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return service.findAllBook(PageRequest.of(page, size));
    }

    @GetMapping("/bookName/{bookname}")
    public List<Book> findBook(@PathVariable("bookname") String bookName) {
        return service.findBook(bookName);
    }


    @GetMapping("/students")
    public ResponseEntity<List<Students>> getStudentList() {
        List<Students> studentsList = service.getStudent();
        return new ResponseEntity<>(studentsList, HttpStatus.OK);
    }

    @GetMapping("/laptops")
    public ResponseEntity<List<Laptops>> getLaptopList(@RequestParam("name") String name) {
        List<Laptops> laptopsList = service.getLaptops(name);
        return new ResponseEntity<>(laptopsList, HttpStatus.OK);
    }

}
