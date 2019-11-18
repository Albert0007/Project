package com.example.demo.repository;

import com.example.demo.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeDAO extends JpaRepository<DocumentType, Integer>{

}