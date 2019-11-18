package com.example.demo.controller;

import com.example.demo.entity.Document;
import com.example.demo.service.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/api",produces = "application/json")
public class DocumentController{
    @Autowired
    DocumentServiceImpl documentServiceImpl;

    @GetMapping(value = "/document/{id}", produces = "application/json")
    public Document getDocument(@PathVariable Integer id) throws SQLException {
        Document document = documentServiceImpl.getDocumentById (id);
        if (document == null || document.getId ( ) <= 0) {
            throw new SQLException ("Document doesn´t exist");
        }
        return documentServiceImpl.getDocumentById (id);
    }

    @GetMapping(value = "/document")
    public List<Document> getAllDocument() {
        return documentServiceImpl.getAllDocument ( );
    }

    @PostMapping(value = "/document/")
    public ResponseEntity<Document> createOrUpdateDocument(@RequestBody Document document)
            throws SQLException {
        return new ResponseEntity<Document> (documentServiceImpl.createOrUpdateDocument (document), HttpStatus.OK);
    }

    @DeleteMapping(value = "/document/{id}")
    public HttpStatus deleteDocumentById(@PathVariable("id") Integer id)
            throws SQLException {
        Document document = documentServiceImpl.getDocumentById (id);
        if (document == null || document.getId ( ) <= 0) {
            throw new SQLException ("Document to delete doesn´t exist");
        }
        documentServiceImpl.deleteDocumentById (id);
        return HttpStatus.FORBIDDEN;
    }
}

