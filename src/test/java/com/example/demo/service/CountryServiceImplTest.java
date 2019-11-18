package com.example.demo.service;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryDAO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class CountryServiceImplTest {

    @Mock
    private CountryDAO countryDAO;

    @InjectMocks
    private CountryServiceImpl countryServiceImpl;

    @Test
    void getCountryPositive() throws SQLException {
        Country country = new Country (1,"name", "code");
        country.setName ("Artem");
        int id = 0;
        when (countryDAO.findById (id)).thenReturn (java.util.Optional.of (country));
        assertEquals (country, countryServiceImpl.getCountry (id));
    }

    @Test
    void getCountryNegative() throws SQLException {
        Country country = new Country (1,"name", "code");
        country.setName ("Albert");
        int id = 0;
        when (countryDAO.findById (id)).thenReturn (java.util.Optional.of (country));
        Assert.assertNull (countryServiceImpl.getCountry (id));
    }


    @Test
    public void getAllUsers() {
        //создаем список  в него помещаем данные для сравнения
        when (countryDAO.findAll ( )).thenReturn (Arrays.<Country>asList (
                new Country (1, "Boris", "12"),
                new Country (2, "Vova", "23"),
               new Country (1,"ап", "sd" )

        ));
        //создаем список  и заполняем его данными нашего метода
        List<Country> result = countryServiceImpl.getAllCountry ( );
        assertEquals (3, result.size ( ));
    }

    @Test
    public void testGetCountryById() throws SQLException {
        Country country = new Country (1,"Boris", "645");
        when (countryDAO.findById (1)).thenReturn (java.util.Optional.of (country));
        Country result = countryServiceImpl.getCountryById (1);
        assertEquals ("Boris", result.getName ( ));
        assertEquals ("645", result.getCode ( ));
    }

    @Test
    public void saveCountry() throws SQLException {
        Country country = new Country (1,"роа", "543" );
        when (countryDAO.save (country)).thenReturn (country);
        Country result = countryServiceImpl.createOrUpdateCountry (country);
        assertEquals ("роа", result.getName ( ));
        assertEquals ("543", result.getCode ( ));
    }

    @Test
    public void deleteCountryById() throws SQLException {
        int id = 1;
        Country country = new Country (1,"VOva", "Todo Sample 8");
        when (countryDAO.findById (id)).thenReturn (java.util.Optional.of ((country)));
        doNothing ( ).when (countryDAO).deleteById (id);
        countryServiceImpl.deleteCountryById (id);
        verify (countryDAO, times (1)).deleteById (id);
    }
}
