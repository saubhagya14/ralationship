package com.example.demo.repo;

import com.example.demo.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookREpo extends JpaRepository<Book, Integer> {

    public Page<Book> findAll(Pageable pageable);

    public List<Book> findByBookName(String bookName);
}
