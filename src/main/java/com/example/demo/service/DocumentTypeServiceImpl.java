package com.example.demo.service;

import com.example.demo.entity.DocumentType;
import com.example.demo.repository.DocumentTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class DocumentTypeServiceImpl {

    @Autowired
    DocumentTypeDAO documentTypeDAO;
    public List<DocumentType> getAllDocumentType() {
        List<DocumentType> documentList = documentTypeDAO.findAll ( );
        if (documentList.size ( ) > 0) {
            return documentList;
        } else
            return new ArrayList<DocumentType> ( );
    }

    public DocumentType getDocumentTypeById(Integer id) throws RuntimeException {
        Optional<DocumentType> document = documentTypeDAO.findById (id);
        if (document.isPresent ( )) {
            return document.get ( );
        } else {
            throw new RuntimeException ("No record exist for given id");
        }
    }

    public DocumentType createOrUpdateDocumentType(DocumentType documentType) throws SQLException {
        Optional<DocumentType> documentType1 = documentTypeDAO.findById (documentType.getId ( ));
        if (documentType1.isPresent ( )) {
            DocumentType documentTypeNew = documentType1.get ( );
            documentTypeNew.setDoc_name (documentType.getDoc_name ( ));
            documentTypeNew.setDoc_number (documentType.getDoc_number ( ));
            documentTypeNew.setDoc_data (documentType.getDoc_data ( ));
            documentTypeNew = documentTypeDAO.save (documentTypeNew);
            return documentTypeNew;
        } else {
            documentType = documentTypeDAO.save (documentType);
            return documentType;
        }
    }

    public void deleteDocumentTypeById(Integer id) throws SQLException {
        Optional<DocumentType> document = documentTypeDAO.findById (id);
        if (document.isPresent ( )) {
            documentTypeDAO.deleteById (id);
        } else {
            throw new SQLException ("No country record exist for given id");
        }
    }
}