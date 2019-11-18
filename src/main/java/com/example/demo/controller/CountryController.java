package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Country;
import com.example.demo.service.CountryServiceImpl;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class CountryController {
    @Autowired
    private CountryServiceImpl countryServiceImpl;

    @GetMapping(value = "/country/{id}")
    public Country getCountry(@PathVariable Integer id) throws SQLException {
        Country country = countryServiceImpl.getCountryById (id);
        if (country == null || country.getId ( ) <= 0) {
            throw new SQLException ("Country doesn´t exist");
        }
        return countryServiceImpl.getCountryById (id);
    }

    @GetMapping(value = "/country")
    public List<Country> getAllCountry() {
        return countryServiceImpl.getAllCountry ( );
    }

    @PostMapping(value = "/country/")
    public ResponseEntity<Country> createOrUpdateCountry(@RequestBody Country country)
            throws SQLException {
        return new ResponseEntity<Country> (countryServiceImpl.createOrUpdateCountry (country), HttpStatus.OK);
    }

    @DeleteMapping(value = "/country/{id}")
    public HttpStatus deleteCountryById(@PathVariable("id") Integer id)
            throws SQLException {
        Country country = countryServiceImpl.getCountryById (id);
        if (country == null || country.getId ( ) <= 0) {
            throw new SQLException ("Country to delete doesn´t exist");
        }
        countryServiceImpl.deleteCountryById (id);
        return HttpStatus.FORBIDDEN;
    }
}



