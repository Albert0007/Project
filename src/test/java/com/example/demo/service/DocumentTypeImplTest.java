package com.example.demo.service;

import com.example.demo.entity.DocumentType;
import com.example.demo.repository.DocumentTypeDAO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class DocumentTypeImplTest {

    @Mock
    private DocumentTypeDAO documentTypeDAO;

    @InjectMocks
    private DocumentTypeServiceImpl documentTypeServiceImpl;

    @Test
    void getDocumentTypePositive() throws SQLException {
        DocumentType documentType = new DocumentType (1,"VOva", "Todo Sample 8","23",1);
        documentType.setDoc_name ("Artem");
        int id = 0;
        when (documentTypeDAO.findById (id)).thenReturn (java.util.Optional.of (documentType));
        assertEquals (documentType, documentTypeServiceImpl.getDocumentTypeById (id));
    }

    @Test
    void getDocumentTypeNegative() throws SQLException {
        DocumentType documentType = new DocumentType (1,"VOva", "Todo Sample 8","23",1);
        documentType.setDoc_name ("Albert");
        int id = 0;
        when (documentTypeDAO.findById (id)).thenReturn (java.util.Optional.of (documentType));
        Assert.assertNull (documentTypeServiceImpl.getDocumentTypeById (id));
    }

    @Test
    public void getAllDocumentType() {
        //создаем список  в него помещаем данные для сравнения
        List<DocumentType> documentTypeList = new ArrayList<DocumentType> ( );
        documentTypeList.add (new DocumentType (1,"VOva", "Todo Sample 8","23",1));
        documentTypeList.add (new DocumentType (2,"VOva", "Todo Sample 8","23",1));
        when (documentTypeDAO.findAll ( )).thenReturn (documentTypeList);
        //создаем список  и заполняем его данными нашего метода
        List<DocumentType> result = documentTypeServiceImpl.getAllDocumentType ( );
        assertEquals (2, result.size ( ));
    }

    @Test
    public void testGetDocumentTypeById() throws SQLException {
        DocumentType documentType = new DocumentType (1,"VOva", "Todo Sample 8","23",1);
        when (documentTypeDAO.findById (1)).thenReturn (java.util.Optional.of (documentType));
        DocumentType result = documentTypeServiceImpl.getDocumentTypeById (1);
        assertEquals ("Boris", result.getDoc_name ( ));
        assertEquals ("645", result.getDoc_number ( ));

    }

    @Test
    public void saveDocumentType() throws SQLException {
        DocumentType documentType = new DocumentType (1,"VOva", "Todo Sample 8","23",1);
        when (documentTypeDAO.save (documentType)).thenReturn (documentType);
        DocumentType result = documentTypeServiceImpl.createOrUpdateDocumentType (documentType);
        assertEquals ("роа", result.getDoc_name ( ));
        assertEquals ("543", result.getDoc_number ( ));
    }

    @Test
    public void deleteDocumentTypeById() throws SQLException {
        int id = 1;
        DocumentType documentType = new DocumentType (1,"VOva", "Todo Sample 8","23",1);
        when (documentTypeDAO.findById (id)).thenReturn (java.util.Optional.of ((documentType)));
        doNothing ( ).when (documentTypeDAO).deleteById (id);
        documentTypeServiceImpl.deleteDocumentTypeById  (id);
        verify (documentTypeDAO, times (1)).deleteById (id);
    }
}

