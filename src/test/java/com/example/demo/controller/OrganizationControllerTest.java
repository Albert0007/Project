package com.example.demo.controller;

import com.example.demo.entity.Organization;
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

public class OrganizationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllOrganization() throws Exception {
        Organization organization = createOrUpdateOrganization ( );
        mockMvc.perform (get ("/api/organization" ))
                .andExpect (status ( ).isOk ( ))
                .andExpect ( jsonPath ("$[*].id").isNotEmpty ())
                .andExpect ( jsonPath ("$", hasToString (String.valueOf (organization))));
    }

    @Test
    public void findById() throws Exception {
        Organization organization = createOrUpdateOrganization();
        mockMvc.perform (get ("/api/organization/" +  organization.getId()))
                .andExpect (status ( ).isOk ( ))
                .andExpect (jsonPath ("$.id", equalTo (organization.getId())))
                .andExpect (jsonPath ("$.fullName", equalTo (organization.getFullName ())));
    }

    @Test
    public void create() throws Exception {
        createOrUpdateOrganization ();
    }
    private Organization createOrUpdateOrganization() throws Exception {
        Organization organization = new Organization (6,"Boris","21", 78,0,"df",3);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(organization);
        Organization result = objectMapper.readerFor(Organization.class).readValue(
                mockMvc.perform (post("/api/organization/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .characterEncoding("utf-8"))
                        .andExpect(status().isOk())
                        .andReturn().getResponse().getContentAsString());
        return result;
    }

    @Test
    public void deleteOrganizationById() throws Exception {
        Organization organization = createOrUpdateOrganization ();
        mockMvc.perform (delete ("/api/organization/"+ organization.getId ()))
                .andExpect (status ( ).isOk ( ));
    }
}