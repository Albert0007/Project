package com.example.demo.service;

import com.example.demo.entity.Country;
import com.example.demo.entity.Document;
import com.example.demo.repository.DocumentDAO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class DocumentServiceImplTest {

    @Mock
    private DocumentDAO documentDAO;

    @InjectMocks
    private DocumentServiceImpl documentServiceImpl;

    @Test
    void getDocumentPositive() throws SQLException {
        Document document = new Document (1,"name", "code");
        document.setName ("Artem");
        int id = 0;
        when (documentDAO.findById (id)).thenReturn (java.util.Optional.of (document));
        assertEquals (document, documentServiceImpl.getDocument (id));
    }

    @Test
    void getDocumentNegative() throws SQLException {
        Document document = new Document (1,"name", "code");
        document.setName ("Albert");
        int id = 0;
        when (documentDAO.findById (id)).thenReturn (java.util.Optional.of (document));
        Assert.assertNull (documentServiceImpl.getDocument (id));
    }

    @Test
    public void getAllUsers() {
        //создаем список  в него помещаем данные для сравнения
        when (documentDAO.findAll ( )).thenReturn (Arrays.<Document>asList (
                new Document (1, "Boris", "12"),
                new Document (2, "Vova", "23"),
                new Document (1,"ап", "sd" )
        ));
        //создаем список  и заполняем его данными нашего метода
        List<Document> result = documentServiceImpl.getAllDocument ( );
        assertEquals (3, result.size ( ));
    }

    @Test
    public void testGetDocumentById() throws SQLException {
        Document document = new Document (1,"Boris", "645");
        when (documentDAO.findById (1)).thenReturn (java.util.Optional.of (document));
        Document result = documentServiceImpl.getDocumentById (1);
        assertEquals ("Boris", result.getName ( ));
        assertEquals ("645", result.getCode ( ));
    }

    @Test
    public void saveDocument() throws SQLException {
        Document document = new Document (1,"роа", "543");
        when (documentDAO.save (document)).thenReturn (document);
        Document result = documentServiceImpl.createOrUpdateDocument (document);
        assertEquals ("роа", result.getName ( ));
        assertEquals ("543", result.getCode ( ));
    }

    @Test
    public void deleteDocumentById() throws SQLException {
        int id = 1;
        Document document = new Document (1,"VOva", "Todo Sample 8");
        when (documentDAO.findById (id)).thenReturn (java.util.Optional.of ((document)));
        doNothing ( ).when (documentDAO).deleteById (id);
        documentServiceImpl.deleteDocumentById (id);
        verify (documentDAO, times (1)).deleteById (id);
    }
}

