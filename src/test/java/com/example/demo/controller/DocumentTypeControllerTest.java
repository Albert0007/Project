package com.example.demo.controller;

import com.example.demo.entity.DocumentType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public  class DocumentTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllDocumentType() throws Exception {
        DocumentType documentType = createOrUpdateDocumentType ( );
        mockMvc.perform (get ("/api/document_type"))
                .andExpect (status ( ).isOk ( ))
                .andExpect ( jsonPath ("$[*].id").isNotEmpty ())
                .andExpect (jsonPath ("$", hasSize (4)));
    }

    @Test
    public void findById() throws Exception {
        DocumentType documentType = createOrUpdateDocumentType();
        mockMvc.perform (get ("/api/document_type/" +  documentType.getId()))
                .andExpect (status ( ).isOk ( ))
                .andExpect (jsonPath ("$.id", equalTo (documentType.getId())))
                .andExpect (jsonPath ("$.doc_name", equalTo (documentType.getDoc_name ())));
    }

    @Test
    public void create() throws Exception {
        createOrUpdateDocumentType ();
    }
    private DocumentType createOrUpdateDocumentType() throws Exception {
        DocumentType documentType = new DocumentType (6,"Boris","21", "78",0);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(documentType);
        DocumentType result = objectMapper.readerFor(DocumentType.class).readValue(
                mockMvc.perform (post("/api/document_type/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .characterEncoding("utf-8"))
                        .andExpect(status().isOk())
                        .andReturn().getResponse().getContentAsString());
        return result;
    }

    @Test
    public void deleteDocumentTypeById() throws Exception {
        DocumentType documentType = createOrUpdateDocumentType ();
        mockMvc.perform (delete ("/api/document_type/"+ documentType.getId ()))
                .andExpect (status ( ).isOk ( ));
    }
}