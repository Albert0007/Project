package com.example.demo.service;

import com.example.demo.entity.Organization;
import com.example.demo.repository.OrganizationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class OrganizationServiceImpl {

    @Autowired
    OrganizationDAO organizationDAO;

    public List<Organization> getAllOrganization() {
        List<Organization> organizationList = organizationDAO.findAll ( );
        if (organizationList.size ( ) > 0) {
            return organizationList;
        } else
            return new ArrayList<Organization> ( );
    }

    public Organization getOrganizationById(Integer id) throws RuntimeException {
        Optional<Organization> organization = organizationDAO.findById (id);
        if (organization.isPresent ( )) {
            return organization.get ( );
        } else {
            throw new RuntimeException ("No record exist for given id");
        }
    }

    public Organization createOrUpdateOrganization(Organization organization) throws SQLException {
        Optional<Organization> organization1 = organizationDAO.findById (organization.getId ( ));
        if (organization1.isPresent ( )) {
            Organization organizationNew = organization1.get ( );
            organizationNew.setName (organization.getName ( ));
            organizationNew.setFullName (organization.getFullName ( ));
            organizationNew.setInn (organization.getInn ( ));
            organizationNew.setKpp (organization.getKpp ( ));
            organizationNew.setAddress (organization.getAddress ( ));
            organizationNew.setPhone (organization.getPhone ( ));
            organizationNew = organizationDAO.save (organizationNew);
            return organizationNew;
        } else {
            organization = organizationDAO.save (organization);
            return organization;
        }
    }

    public void deleteOrganizationById(Integer id) throws SQLException {
        Optional<Organization> organization = organizationDAO.findById (id);
        if (organization.isPresent ( )) {
            organizationDAO.deleteById (id);
        } else {
            throw new SQLException ("No country record exist for given id");
        }
    }
}




