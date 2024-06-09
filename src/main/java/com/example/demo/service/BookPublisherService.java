package com.example.demo.service;

import com.example.demo.CustomErrorHandling;
import com.example.demo.entity.*;
import com.example.demo.repo.BookREpo;
import com.example.demo.repo.LaptopsRepo;
import com.example.demo.repo.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookPublisherService {

    @Autowired
    BookREpo bookREpo;

    @Autowired
    StudentsRepo studentsRepo;

    @Autowired
    LaptopsRepo laptopsRepo;

    public void saveAllBooks(List<Book> books) {
        bookREpo.saveAll(books);
    }

    public CustomeDTO findAllBook(PageRequest pageRequest) {
        Page<Book> bookPage = bookREpo.findAll(pageRequest);
        List<DTO> list =  bookPage.stream().map(DTO::convertToDto).collect(Collectors.toList());

        return new CustomeDTO(bookPage.getTotalPages(), list);
    }

    public List<Book> findBook(String bookName) {
        return bookREpo.findByBookName(bookName);
    }

    public List<Students> getStudent() {
     return studentsRepo.findAll();
    }

    public List<Laptops> getLaptops(String name) {
        System.out.println("name is : " + name);
        if ((name == null) || name.isEmpty()) {
            throw new CustomErrorHandling("name field can't be blank");
        }

        List<Laptops> laptopsList = laptopsRepo.findLaptopByName(name);

        if (laptopsList.isEmpty()) {
            throw new CustomErrorHandling("No laptops found on the given name");
        }

        return laptopsList;
    }

}
