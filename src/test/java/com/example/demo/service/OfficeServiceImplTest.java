package com.example.demo.service;

import com.example.demo.entity.Office;
import com.example.demo.repository.OfficeDAO;
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
class OfficeServiceImplTest {

    @Mock
    private OfficeDAO officeDAO;

    @InjectMocks
    private OfficeServiceImpl officeServiceImpl;

    @Test
    void getOfficePositive() throws SQLException {
        Office office = new Office (1,"VOva", "Todo Sample 8",3,1);
        office.setFirstName ("Artem");
        int id = 0;
        when (officeDAO.findById (id)).thenReturn (java.util.Optional.of (office));
        assertEquals (office, officeServiceImpl.getOfficeById (id));
    }

    @Test
    void getOfficeNegative() throws SQLException {
        Office office = new Office (1,"VOva", "Todo Sample 8",3,1);
        office.setFirstName ("Albert");
        int id = 0;
        when (officeDAO.findById (id)).thenReturn (java.util.Optional.of (office));
        Assert.assertNull (officeServiceImpl.getOfficeById (id));
    }

    @Test
    public void getAllOffice() {
        //создаем список  в него помещаем данные для сравнения
        List<Office> officeList = new ArrayList<Office> ( );
        officeList.add (new Office (1,"VOva", "Todo Sample 8",3,1));
        officeList.add (new Office (2,"VOva", "Todo Sample 8",3,1));
        when (officeDAO.findAll ( )).thenReturn (officeList);
        //создаем список  и заполняем его данными нашего метода
        List<Office> result = officeServiceImpl.getAllOffice ( );
        assertEquals (2, result.size ( ));
    }

    @Test
    public void testGetOfficeById() throws SQLException {
        Office office = new Office (1,"VOva", "Todo Sample 8",3,1);
        when (officeDAO.findById (1)).thenReturn (java.util.Optional.of (office));
        Office result = officeServiceImpl.getOfficeById (1);
        assertEquals ("Boris", result.getFirstName ( ));
        assertEquals ("645", result.getPhone ( ));
    }

    @Test
    public void saveOffice() throws SQLException {
        Office office = new Office (1,"VOva", "Todo Sample 8",3,1);
        when (officeDAO.save (office)).thenReturn (office);
        Office result = officeServiceImpl.createOrUpdateOffice(office);
        assertEquals ("роа", result.getFirstName ( ));
        assertEquals ("543", result.getPhone ( ));
    }

    @Test
    public void deleteOfficeById() throws SQLException {
        int id = 1;
        Office office = new Office (1,"VOva", "Todo Sample 8",3,1);
        when (officeDAO.findById (id)).thenReturn (java.util.Optional.of ((office)));
        doNothing ( ).when (officeDAO).deleteById (id);
        officeServiceImpl.deleteOfficeById  (id);
        verify (officeDAO, times (1)).deleteById (id);
    }
}

