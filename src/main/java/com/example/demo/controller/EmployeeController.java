package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value="/api", produces = "application/json" )
public class EmployeeController {
   @Autowired
    EmployeeServiceImpl employeeServiceImpl;

   @GetMapping(value = "/employee/{id}")
    public Employee getEmployee (@PathVariable Integer id) throws SQLException {
        Employee employee = employeeServiceImpl.getEmployeeById (id);
        if (employee == null || employee.getId ( ) <= 0) {
            throw new SQLException ("Document doesn´t exist");
        }
        return employeeServiceImpl.getEmployeeById  (id);
    }

    @GetMapping(value = "/employee")
    public List<Employee> getAllDEmployee() {
        return employeeServiceImpl.getAllEmployee ( );
    }

    @PostMapping(value="/employee/")
    public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee)
            throws SQLException {
        return new ResponseEntity<Employee> (employeeServiceImpl.createOrUpdateEmployee (employee), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Integer id)
            throws SQLException {
        Employee employee = employeeServiceImpl.getEmployeeById (id);
        if (employee == null || employee.getId ( ) <= 0) {
            throw new SQLException ("Country to delete doesn´t exist");
        }
        employeeServiceImpl.deleteEmployeeById (id);
        return HttpStatus.FORBIDDEN;
    }
}





