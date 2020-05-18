package com.example.demo2.documents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = " CR_CAMPOS")
public class Campos {

    @Id
    @GeneratedValue(generator = "prod-generator-activi")
    @GenericGenerator(name = "prod-generator-activi", parameters = @Parameter(name = "prefix", value = "Cp"), strategy = "com.example.demo2.documents.StringGenerator")
    private String id;

    private String campo;

    @Column(name = "ejes_id")
    private String ejesId;

    public Campos() {
    }

    public Campos(String id, String campo, String ejesId) {
        this.id = id;
        this.campo = campo;
        this.ejesId = ejesId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getEjesId() {
        return ejesId;
    }

    public void setEjesId(String ejesId) {
        this.ejesId = ejesId;
    }

}