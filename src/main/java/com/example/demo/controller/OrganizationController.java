package com.example.demo.controller;

import com.example.demo.entity.Organization;
import com.example.demo.service.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class OrganizationController {

    @Autowired
    OrganizationServiceImpl organizationServiceImpl;

    @GetMapping(value = "/organization/{id}", produces = "application/json")
    public Organization organization(@PathVariable Integer id) throws SQLException {
        Organization organization = organizationServiceImpl.getOrganizationById (id);
        if (organization == null || organization.getId ( ) <= 0) {
            throw new SQLException ("Document doesn´t exist");
        }
        return organizationServiceImpl.getOrganizationById (id);
    }

    @GetMapping(value = "/organization")
    public List<Organization> getAllOrganization() {
        return organizationServiceImpl.getAllOrganization ( );
    }

    @PostMapping(value = "/organization/")
    public ResponseEntity<Organization> createOrUpdateOrganization(@RequestBody Organization organization)
            throws SQLException {
        return new ResponseEntity<Organization> (organizationServiceImpl.createOrUpdateOrganization (organization), HttpStatus.OK);
    }

    @DeleteMapping(value = "/organization/{id}")
    public HttpStatus deleteOrganizationById(@PathVariable("id") Integer id)
            throws SQLException {
        Organization organization = organizationServiceImpl.getOrganizationById (id);
        if (organization == null || organization.getId ( ) <= 0) {
            throw new SQLException ("Country to delete doesn´t exist");
        }
        organizationServiceImpl.deleteOrganizationById (id);
        return HttpStatus.FORBIDDEN;
    }
}