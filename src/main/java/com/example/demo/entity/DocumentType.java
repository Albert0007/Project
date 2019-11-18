package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="DOCUMENT_TYPE")
public class DocumentType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "version")
    private Integer version;

    @Column(name = "DOC_NAME")
    private String doc_name;

    @Column(name = "DOC_NUMBER")
    private String doc_number;

    @Column(name = "DOC_DATA")
    private String doc_data;

    @ManyToOne
    @JoinColumn(name= "document_id")
    private Document document;

    public DocumentType(){
    }

    public  DocumentType(Integer id,String name, String number, String data, Integer document_id){
        this.id = id;
        this.doc_name = name;
        this.doc_number = number;
        this.doc_data = data;
        this.version = 0;
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

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getDoc_number() {
        return doc_number;
    }

    public void setDoc_number(String doc_number) {
        this.doc_number = doc_number;
    }

    public String getDoc_data() {
        return doc_data;
    }

    public void setDoc_data(String doc_data) {
        this.doc_data = doc_data;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "DocumentType{" +
                "id=" + id +
                ", doc_name='" + doc_name + '\'' +
                ", doc_number='" + doc_number + '\'' +
                ", doc_data='" + doc_data + '\'' +
                '}';
    }
}
