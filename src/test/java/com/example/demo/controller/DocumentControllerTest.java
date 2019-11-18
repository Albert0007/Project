package com.example.demo.controller;

import com.example.demo.entity.Document;
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
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class DocumentControllerTest {

    @Autowired
    private MockMvc mockMvc;

     @Test
    public void getDocument() throws Exception {
         Document document = creatOrUpdateDocument();
         mockMvc.perform (get ("/api/document" ))
                .andExpect (status ().isOk ())
                 .andExpect ( jsonPath ("$[*].id").isNotEmpty ())
                 .andExpect (jsonPath ("$", hasSize (4)));
     }

     @Test
    public void getDocumentById() throws Exception {
         Document document = creatOrUpdateDocument();
         mockMvc.perform(get ("/api/document/" + document.getId ()))
                 .andExpect (status ().isOk ())
                 .andExpect (jsonPath ("$.id", equalTo(document.getId())))
                 .andExpect (jsonPath ("$.name",equalTo (document.getName ())));
     }

    @Test
     public void creat() throws Exception{
         creatOrUpdateDocument ();
     }
    public Document creatOrUpdateDocument() throws Exception {
         Document document = new Document (5, "Паспорт","21");
        ObjectMapper objectMapper = new ObjectMapper ();
        String json = objectMapper.writeValueAsString (document);
        Document result = objectMapper.readerFor (Document.class).readValue (
            mockMvc.perform (post("/api/document/")
            .contentType (MediaType.APPLICATION_JSON)
            .content(json)
                    .characterEncoding ("utf-8"))
                .andExpect(status ().isOk ())
                .andReturn ().getResponse ().getContentAsString ());
        return result;
     }

@Test
    public void deleteDocumentById() throws Exception {
         Document document = creatOrUpdateDocument ();
         mockMvc.perform (delete("/api/document/" + document.getId ()))
                 .andExpect (status ().isOk ());
     }
}



