package com.example.demo.service;

import com.example.demo.entity.Country;

import com.example.demo.repository.CountryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CountryServiceImpl {
    @Autowired
    CountryDAO countryDAO;

    public List<Country> getAllCountry() {
        List<Country> countryList = countryDAO.findAll ( );
        if (countryList.size ( ) > 0) {
            return countryList;
        } else {
            return new ArrayList<Country> ( );
        }
    }

    public Country getCountry(Integer id)  {
        Optional<Country> country = countryDAO.findById (id);
        if (country.isPresent ( ) && !country.get ( ).getName ( ).equals ("Albert")) {
            return country.get ( );
        }
        return null;
    }

    public Country getCountryById(Integer id) throws SQLException {
        Optional<Country> country = countryDAO.findById (id);
        if (country.isPresent ( )) {
            return country.get ( );
        } else {
            throw new SQLException ("No record exist for given id");
        }
    }

    public Country createOrUpdateCountry(Country country) throws SQLException {
        Optional<Country> country1 = countryDAO.findById (country.getId ( ));
        if (country1.isPresent ( )) {
            Country newCountry = country1.get ( );
            newCountry.setName (country.getName ( ));
            newCountry.setCode (country.getCode ( ));
            newCountry = countryDAO.save (newCountry);
            return newCountry;
        } else {
            Country savedCountry = countryDAO.save(country);
            return savedCountry;
        }
    }

    public void deleteCountryById(Integer id) throws SQLException {
        Optional<Country> country = countryDAO.findById (id);
        if (country.isPresent ( )) {
            countryDAO.deleteById (id);
        } else {
            throw new SQLException ("No country record exist for given id");
        }
    }
}


