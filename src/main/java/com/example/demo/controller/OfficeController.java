package com.example.demo.controller;

import com.example.demo.entity.Office;
import com.example.demo.service.OfficeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class OfficeController {
     @Autowired
    OfficeServiceImpl officeServiceImpl;

   @GetMapping(value = "/office/{id}", produces = "application/json")
    public Office getOffice(@PathVariable Integer id) throws SQLException {
        Office office = officeServiceImpl.getOfficeById (id);
        if (office == null || office.getId ( ) <= 0) {
            throw new SQLException ("Document doesn´t exist");
        }
        return officeServiceImpl.getOfficeById (id);
    }

    @GetMapping(value = "/office")
    public List<Office> getAllOffice() {
        return officeServiceImpl.getAllOffice ( );
    }

    @PostMapping(value = "/office/")
    public ResponseEntity<Office> createOrUpdateOffice(@RequestBody Office office)
            throws SQLException {
        return new ResponseEntity<Office> (officeServiceImpl.createOrUpdateOffice (office), HttpStatus.OK);
    }

    @DeleteMapping(value = "/office/{id}")
    public HttpStatus deleteOfficeById(@PathVariable("id") Integer id)
            throws SQLException {
        Office office = officeServiceImpl.getOfficeById (id);
        if (office == null || office.getId ( ) <= 0) {
            throw new SQLException ("Country to delete doesn´t exist");
        }
        officeServiceImpl.deleteOfficeById (id);
        return HttpStatus.FORBIDDEN;
    }
}




