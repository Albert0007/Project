package com.example.demo.controller;


import com.example.demo.entity.DocumentType;
import com.example.demo.service.DocumentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class DocumentTypeController {
    @Autowired
    DocumentTypeServiceImpl documentTypeServiceImpl;

    @GetMapping(value = "/document_type/{id}", produces = "application/json")
    public DocumentType getDocumentType(@PathVariable Integer id) throws SQLException {
        DocumentType documentType = documentTypeServiceImpl.getDocumentTypeById (id);
        if (documentType == null || documentType.getId ( ) <= 0) {
            throw new SQLException ("Document doesn´t exist");
        }
        return documentTypeServiceImpl.getDocumentTypeById (id);
    }

    @GetMapping(value = "/document_type")
    public List<DocumentType> getAllDocumentType() {
        return documentTypeServiceImpl.getAllDocumentType ( );
    }

    @PostMapping(value = "/document_type/")
    public ResponseEntity<DocumentType> createOrUpdateDocumentType(@RequestBody DocumentType documentType)
            throws SQLException {
        return new ResponseEntity<DocumentType> (documentTypeServiceImpl.createOrUpdateDocumentType (documentType), HttpStatus.OK);
    }

    @DeleteMapping(value = "/document_type/{id}")
    public HttpStatus deleteDocumentTypeById(@PathVariable("id") Integer id)
            throws SQLException {
        DocumentType documentType = documentTypeServiceImpl.getDocumentTypeById (id);
        if (documentType == null || documentType.getId ( ) <= 0) {
            throw new SQLException ("Country to delete doesn´t exist");
        }
        documentTypeServiceImpl.deleteDocumentTypeById (id);
        return HttpStatus.FORBIDDEN;
    }
}


