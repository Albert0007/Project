package com.example.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "OFFICE")
public class Office  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "version")
    private Integer version;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private Integer phone;

    @Column(name = "IS_ACTIVE")
    private boolean is_active;

    @Column(name = "ORGANIZATION_ID")
    private Integer organization_id;

    public Office(Integer id, String firstName, String address, Integer phone, Integer organization_id) {
        this.id = id;
        this.version = 0;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
        this.organization_id = organization_id;
    }

    @ManyToMany(
    cascade = {
        CascadeType.PERSIST,
                CascadeType.MERGE
    }
    )
    @JoinTable(
            name = "OFFICE_ORGANIZATION",
            joinColumns = @JoinColumn(name = "OFFICE_ID"),
            inverseJoinColumns = @JoinColumn(name = "ORGANIZATION_ID")
    )

    private Set<Organization> organizations;
    public void addJob1(Organization organization) { organizations.add(organization); organization.getOffices ().add(this);
    }
    public void removeJob2(Organization organization) { organizations.remove(organization); organization.getOffices ().remove(this);
    }


   @ManyToMany(mappedBy = "offices")
    private List<Employee> employees;
    public List<Employee> getEmployee() { if (employees == null) {
        employees = new ArrayList<> (); }
        return employees; }

    public Office(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Integer getOrg_id() {
        return organization_id;
    }

    public void setOrg_id(Integer org_id) {
        this.organization_id = org_id;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", is_active=" + is_active +
                ", org_id=" + organization_id +
                ", organizations=" + organizations +
                ", employees=" + employees +
                '}';
    }
}


