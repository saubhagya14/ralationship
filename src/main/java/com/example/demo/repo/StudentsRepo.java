package com.example.demo.repo;

import com.example.demo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo extends JpaRepository<Students, Integer> {

}
