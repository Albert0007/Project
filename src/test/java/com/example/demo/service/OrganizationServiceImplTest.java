package com.example.demo.service;

import com.example.demo.entity.Organization;
import com.example.demo.repository.OrganizationDAO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class OrganizationServiceImplTest {

    @Mock
    private OrganizationDAO organizationDAO;

    @InjectMocks
    private OrganizationServiceImpl organizationServiceImpl;

    @Test
    void getOrganizationPositive() throws SQLException {
        Organization organization = new Organization (1,"VOva", "Todo Sample 8",3,1,"1",2);
        organization.setName ("Artem");
        int id = 0;
        when (organizationDAO.findById (id)).thenReturn (java.util.Optional.of (organization));
        assertEquals (organization, organizationServiceImpl.getOrganizationById (id));
    }

    @Test
    void getOrganizationNegative() throws SQLException {
        Organization organization = new Organization (1,"VOva", "Todo Sample 8",3,1,"1",2);
        organization.setName ("VOva");
        int id = 1;
        when (organizationDAO.findById (id)).thenReturn (java.util.Optional.of (organization));
        Assert.assertNull (organizationServiceImpl.getOrganizationById (id));
    }

    @Test
    public void getAllOrganization() {
        //создаем список  в него помещаем данные для сравнения
        List<Organization> organizationList = new ArrayList<Organization> ( );
        organizationList.add (new Organization (1,"VOva", "Todo Sample 8",3,1,"1",2));
        organizationList.add (new Organization (2,"VOva", "Todo Sample 8",3,1,"1",2));
        when (organizationDAO.findAll ( )).thenReturn (organizationList);
        //создаем список  и заполняем его данными нашего метода
        List<Organization> result = organizationServiceImpl.getAllOrganization ( );
        assertEquals (2, result.size ( ));
    }

    @Test
    public void testGetOrganizationById() throws SQLException {
        Organization organization = new Organization (1,"VOva", "Todo Sample 8",3,1,"1",2);
        when (organizationDAO.findById (1)).thenReturn (java.util.Optional.of (organization));
        Organization result = organizationServiceImpl.getOrganizationById (1);
        assertEquals ("VOva", result.getName ( ));
        assertEquals ("1", result.getAddress ( ));
    }

    @Test
    public void saveOrganization() throws SQLException {
        Organization organization = new Organization (1,"VOva", "Todo Sample 8",3,1,"1",2);
        when (organizationDAO.save (organization)).thenReturn (organization);
        Organization result = organizationServiceImpl.createOrUpdateOrganization(organization);
        assertEquals ("VOva", result.getName ( ));
        assertEquals ("1", result.getAddress ( ));
    }

    @Test
    public void deleteOrganizationById() throws SQLException {
        int id = 1;
        Organization organization = new Organization (1,"VOva", "Todo Sample 8",3,1,"1",2);
        when (organizationDAO.findById (id)).thenReturn (java.util.Optional.of ((organization)));
        doNothing ( ).when (organizationDAO).deleteById (id);
        organizationServiceImpl.deleteOrganizationById  (id);
        verify (organizationDAO, times (1)).deleteById (id);
    }
}


