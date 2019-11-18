package com.example.demo.service;

import com.example.demo.entity.Office;
import com.example.demo.repository.OfficeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class OfficeServiceImpl  {

    @Autowired
    OfficeDAO officeDAO;

    public List<Office> getAllOffice() {
        List<Office> officeList = officeDAO.findAll ( );
        if (officeList.size ( ) > 0) {
            return officeList;
        } else
            return new ArrayList<Office> ( );
    }

    public Office getOfficeById(Integer id) throws RuntimeException {
        Optional<Office> office = officeDAO.findById (id);
        if (office.isPresent ( )) {
            return office.get ( );
        } else {
            throw new RuntimeException ("No record exist for given id");
        }
    }

    public Office createOrUpdateOffice(Office office) throws SQLException {
        Optional<Office> office1 = officeDAO.findById (office.getId ( ));
        if (office1.isPresent ( )) {
            Office officeNew = office1.get ( );
            officeNew.setFirstName (office.getFirstName ( ));
            officeNew.setAddress (office.getAddress ( ));
            officeNew.setPhone (office.getPhone ( ));
            officeNew.setOrg_id (office.getOrg_id ( ));
            officeNew = officeDAO.save (officeNew);
            return officeNew;
        } else {
            office = officeDAO.save (office);
            return office;
        }
    }

    public void deleteOfficeById(Integer id) throws SQLException {
        Optional<Office> office = officeDAO.findById (id);
        if (office.isPresent ( )) {
            officeDAO.deleteById (id);
        } else {
            throw new SQLException ("No country record exist for given id");
        }
    }
}


