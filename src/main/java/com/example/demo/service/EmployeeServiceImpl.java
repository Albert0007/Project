package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service

public class EmployeeServiceImpl {

    @Autowired
    EmployeeDAO employeeDAO;

    public List<Employee> getAllEmployee() {
        List<Employee> documentList = employeeDAO.findAll ( );
        if (documentList.size ( ) > 0) {
            return documentList;
        } else
            return new ArrayList<Employee> ( );
    }

    public Employee getEmployeeById(int id) throws RuntimeException {
        Optional<Employee> employee = employeeDAO.findById (Math.toIntExact (id));
        if (employee.isPresent ( )) {
            return employee.get ( );
        } else {
            throw new RuntimeException ("No record exist for given id");
        }
    }

    public Employee createOrUpdateEmployee(Employee employee) throws SQLException {
        Optional<Employee> employee1 = employeeDAO.findById (employee.getId ( ));
        if (employee1.isPresent ( )) {
            Employee employeeNew = employee1.get ( );
            employeeNew.setFirstName (employee.getFirstName ( ));
            employeeNew.setSecondName (employee.getSecondName ( ));
            employeeNew.setMiddleName (employee.getMiddleName ( ));
            employeeNew.setPosition (employee.getPosition ( ));
            employeeNew.setPhone (employee.getPhone ( ));
            employeeNew.setMiddleName (employee.getMiddleName ( ));
            employeeNew = employeeDAO.save (employeeNew);
            return employeeNew;
        } else {
            employee = employeeDAO.save (employee);
            return employee;
        }
    }

    public void deleteEmployeeById(Integer id) throws SQLException {
        Optional<Employee> employee = employeeDAO.findById (Math.toIntExact (id));
        if (employee.isPresent ( )) {
            employeeDAO.deleteById (Math.toIntExact (id));
        } else {
            throw new SQLException ("No country record exist for given id");
        }
    }
}

