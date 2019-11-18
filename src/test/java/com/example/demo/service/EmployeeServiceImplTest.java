package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeDAO;
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
class EmployeeServiceImplTest {

    @Mock
    private EmployeeDAO employeeDAO;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    @Test
    void getEmployeePositive() throws SQLException {
        Employee employee = new Employee (1,"VOva", "Todo Sample 8","23","1","f");
        employee.setMiddleName ("Artem");
        int id = 0;
        when (employeeDAO.findById (id)).thenReturn (java.util.Optional.of (employee));
        assertEquals (employee, employeeServiceImpl.getEmployeeById (id));
    }

    @Test
    void getEmployeeNegative() throws SQLException {
        Employee employee = new Employee (1,"VOva", "Todo Sample 8","23","1","f");
        employee.setMiddleName ("Albert");
        int id = 0;
        when (employeeDAO.findById (id)).thenReturn (java.util.Optional.of (employee));
        Assert.assertNull (employeeServiceImpl.getEmployeeById (id));
    }

    @Test
    public void getAllEmployee() {
        //создаем список  в него помещаем данные для сравнения
        List<Employee> employeeList = new ArrayList<Employee> ( );
        employeeList.add (new Employee (1,"VOva", "Todo Sample 8","23","1","f"));
        employeeList.add (new Employee (2,"VOva", "Todo Sample 8","23","1","f"));
        when (employeeDAO.findAll ( )).thenReturn (employeeList);
        //создаем список  и заполняем его данными нашего метода
        List<Employee> result = employeeServiceImpl.getAllEmployee ( );
        assertEquals (2, result.size ( ));
    }

    @Test
    public void testGetEmployeeById() throws SQLException {
        Employee employee = new Employee (1,"VOva", "Todo Sample 8","23","1","f");
        when (employeeDAO.findById (1)).thenReturn (java.util.Optional.of (employee));
        Employee result = employeeServiceImpl.getEmployeeById (1);
        assertEquals ("Boris", result.getMiddleName ( ));
        assertEquals ("645", result.getPhone ( ));
    }

    @Test
    public void saveEmployee() throws SQLException {
        Employee employee = new Employee (1,"VOva", "Todo Sample 8","23","1","f");
        when (employeeDAO.save (employee)).thenReturn (employee);
        Employee result = employeeServiceImpl.createOrUpdateEmployee (employee);
        assertEquals ("роа", result.getMiddleName ( ));
        assertEquals ("543", result.getPhone ( ));
    }

    @Test
    public void deleteEmployeeById() throws SQLException {
        int id = 1;
        Employee employee = new Employee (1,"VOva", "Todo Sample 8","23","1","f");
        when (employeeDAO.findById (id)).thenReturn (java.util.Optional.of ((employee)));
        doNothing ( ).when (employeeDAO).deleteById (id);
        employeeServiceImpl.deleteEmployeeById  (id);
        verify (employeeDAO, times (1)).deleteById (id);
    }
}

