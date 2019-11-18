package com.example.demo.controller;

import com.example.demo.entity.Employee;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllEmployee() throws Exception {
        Employee employee = createOrUpdateEmployee();
        mockMvc.perform (get ("/api/employee" ))
                .andExpect (status ( ).isOk ( ))
                .andExpect ( jsonPath ("$[*].id").isNotEmpty ())
                .andExpect (jsonPath ("$", hasSize (6)));
    }

    @Test
    public void findById() throws Exception {
        Employee employee = createOrUpdateEmployee();
        mockMvc.perform (get ("/api/employee/" +  employee.getId()))
                .andExpect (status ( ).isOk ( ))
                .andExpect (jsonPath ("$.id", equalTo (employee.getId())))
                .andExpect (jsonPath ("$.middleName", equalTo (employee.getMiddleName ())));
    }

    @Test
    public void create() throws Exception {
        createOrUpdateEmployee ();
    }
    private Employee createOrUpdateEmployee() throws Exception {
        Employee employee = new Employee (4,"Boris","21", "78","0","gg");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(employee);

        Employee result = objectMapper.readerFor(Employee.class).readValue(
                mockMvc.perform (post("/api/employee/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .characterEncoding("utf-8"))
                        .andExpect(status().isOk())
                        .andReturn().getResponse().getContentAsString());
        return result;
    }

    @Test
    public void deleteEmployeeById() throws Exception {
        Employee employee = createOrUpdateEmployee ();
        mockMvc.perform (delete ("/api/employee/"+ employee.getId ()))
                .andExpect (status ( ).isOk ( ));
    }
}
