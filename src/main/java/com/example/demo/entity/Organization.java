package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ORGANIZATION")
public class Organization implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "version")
        private Integer version;

        @Column(name = "NAME")
        private String name;

        @Column(name = "FULL_NAME")
        private String fullName;

        @Column(name = "INN")
        private Integer inn;

        @Column(name = "KPP")
        private Integer kpp;

        @Column(name = "ADDRESS")
        private String address;

        @Column(name = "PHONE")
        private Integer phone;

        @Column(name = "IS_ACTIVE")
        private boolean is_active;

        public Organization() {
        }

        public Organization(Integer id, String name, String fullName, Integer inn, Integer kpp,
                            String address, Integer phone) {
                this.id = id;
                this.version = 0;
                this.name = name;
                this.fullName = fullName;
                this.inn = inn;
                this.kpp = kpp;
                this.address = address;
                this.phone = phone;
        }

        @ManyToMany(mappedBy = "organizations")
        private List<Office> offices;
        public List<Office> getOffice() { if (offices == null) {
                offices = new ArrayList<> (); }
                return offices; }

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

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getFullName() {
                return fullName;
        }

        public void setFullName(String fullName) {
                this.fullName = fullName;
        }

        public Integer getInn() {
                return inn;
        }

        public void setInn(Integer inn) {
                this.inn = inn;
        }

        public Integer getKpp() {
                return kpp;
        }

        public void setKpp(Integer kpp) {
                this.kpp = kpp;
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

        public List<Office> getOffices() {
                return offices;
        }

        public void setOffices(List<Office> offices) {
                this.offices = offices;
        }

        @Override
        public String toString() {
                return "Organization{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", fullName='" + fullName + '\'' +
                        ", inn=" + inn +
                        ", kpp=" + kpp +
                        ", address='" + address + '\'' +
                        ", phone=" + phone +
                        ", is_active=" + is_active +
                        ", offices=" + offices +
                        '}';
        }
}
