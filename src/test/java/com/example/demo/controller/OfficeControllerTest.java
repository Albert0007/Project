package com.example.demo.controller;

import com.example.demo.entity.Office;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class OfficeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllOffice() throws Exception {
        Office office = createOrUpdateOffice ( );
        mockMvc.perform (get ("/api/office" ))
                .andExpect (status ( ).isOk ( ))
                .andExpect ( jsonPath ("$[*].id").isNotEmpty ())
                .andExpect ( jsonPath ("$", hasToString (String.valueOf (office))));
    }

    @Test
    public void findById() throws Exception {
        Office office = createOrUpdateOffice();
        mockMvc.perform (get ("/api/office/" +  office.getId()))
                .andExpect (status ( ).isOk ( ))
                .andExpect (jsonPath ("$.id", equalTo (office.getId())))
                .andExpect (jsonPath ("$.firstName", equalTo (office.getFirstName ())));
    }

    @Test
    public void create() throws Exception {
        createOrUpdateOffice ();
    }
    private Office createOrUpdateOffice() throws Exception {
        Office office = new Office (6,"Boris","21", 78,1);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(office);
        Office result = objectMapper.readerFor(Office.class).readValue(
                mockMvc.perform (post("/api/office/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .characterEncoding("utf-8"))
                        .andExpect(status().isOk())
                        .andReturn().getResponse().getContentAsString());
        return result;
    }

    @Test
    public void deleteOfficeById() throws Exception {
        Office office = createOrUpdateOffice ();
        mockMvc.perform (delete ("/api/office/"+ office.getId ()))
                .andExpect (status ( ).isOk ( ));
    }
}

