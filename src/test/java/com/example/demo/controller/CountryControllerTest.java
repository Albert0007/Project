package com.example.demo.controller;

import com.example.demo.entity.Country;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllCountry() throws Exception {
     Country country = createOrUpdateCountry ( );
        mockMvc.perform (get ("/api/country" ))
                .andExpect (status ( ).isOk ( ))
                .andExpect ( jsonPath ("$[*].id").isNotEmpty ())
                .andExpect (jsonPath ("$", hasSize (6)));
    }

    @Test
    public void findById() throws Exception {
        Country country = createOrUpdateCountry();
        mockMvc.perform (get ("/api/country/" +  country.getId()))
                .andExpect (status ( ).isOk ( ))
                .andExpect (jsonPath ("$.id", equalTo (country.getId())))
                .andExpect (jsonPath ("$.name", equalTo (country.getName())));
    }

    @Test
    public void create() throws Exception {
        createOrUpdateCountry ();
    }
    private Country createOrUpdateCountry() throws Exception {
        Country country = new Country (100,"Boris","21");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(country);

        Country result = objectMapper.readerFor(Country.class).readValue(
            mockMvc.perform (post("/api/country/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json)
                    .characterEncoding("utf-8"))
                    .andExpect(status().isOk())
                    .andReturn().getResponse().getContentAsString());
        return result;
    }

    @Test
   public void deleteCountryById() throws Exception {
       Country country = createOrUpdateCountry ();
        mockMvc.perform (delete ("/api/country/"+ country.getId ()))
                .andExpect (status ( ).isOk ( ));
    }
}