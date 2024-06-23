package com.example.demo.controller.MyController;

import com.example.demo.entity.*;
import com.example.demo.service.BookPublisherService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    BookPublisherService service;
    @Autowired
    StudentService studentService;


    @GetMapping("/all")
    public CustomeDTO all(@RequestParam(defaultValue = "0") int page, @RequestParam("size") Integer size) {
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

    @PostMapping("/save-student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
       Student students1 = studentService.addStudent(student);
       return new ResponseEntity<>(students1, HttpStatus.OK);
    }

}
