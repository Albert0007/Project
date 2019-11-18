package com.example.demo.repository;


import com.example.demo.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDAO extends JpaRepository<Document, Integer>{

}