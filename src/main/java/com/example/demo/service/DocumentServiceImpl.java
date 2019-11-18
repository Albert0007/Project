package com.example.demo.service;

import com.example.demo.entity.Country;
import com.example.demo.entity.Document;
import com.example.demo.repository.DocumentDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class DocumentServiceImpl {

   @Autowired
    DocumentDAO documentDAO;

    public List<Document> getAllDocument() {
        List<Document> documentList = documentDAO.findAll ( );
        if (documentList.size ( ) > 0) {
            return documentList;
        } else
            return new ArrayList<Document> ( );
    }

    public Document getDocument(Integer id) throws SQLException {
        Optional<Document> document = documentDAO.findById (id);
        if (document.isPresent ( ) && !document.get ( ).getName ( ).equals ("Albert")) {
            return document.get ( );
        }
        return null;
    }

    public Document getDocumentById(Integer id) throws RuntimeException {
        Optional<Document> document = documentDAO.findById (id);
        if (document.isPresent ( )) {
            return document.get ( );
        } else {
            throw new RuntimeException ("No record exist for given id");
        }
    }

    public  Document createOrUpdateDocument(Document document) throws SQLException {
        Optional<Document> document1 = documentDAO.findById (document.getId ( ));
        if (document1.isPresent ( )) {
            Document documentNew = document1.get ( );
            documentNew.setName (document.getName ( ));
            documentNew.setCode (document.getCode ( ));
            documentNew = documentDAO.save (documentNew);
            return documentNew;
        } else {
            document = documentDAO.save (document);
            return document;
        }
    }
    public void deleteDocumentById(Integer id) throws SQLException {
        Optional<Document> document = documentDAO.findById (id);
        if (document.isPresent ( )) {
            documentDAO.deleteById (id);
        } else {
            throw new SQLException ("No country record exist for given id");
        }
    }
}

