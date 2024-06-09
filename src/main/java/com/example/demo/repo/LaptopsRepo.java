package com.example.demo.repo;

import com.example.demo.entity.Laptops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopsRepo extends JpaRepository<Laptops, Integer> {
    @Query(value = "select * from laptops where sid in(select id from students where name = :name)", nativeQuery = true)
    public List<Laptops> findLaptopByName(String name);
}
