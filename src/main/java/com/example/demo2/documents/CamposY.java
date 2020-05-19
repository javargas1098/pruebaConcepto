package com.example.demo2.documents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CR_PUNTOSY")
public class CamposY {
    @Id
    @GeneratedValue(generator = "prod-generator-activi")
    @GenericGenerator(name = "prod-generator-activi", parameters = @Parameter(name = "prefix", value = "CpY"), strategy = "com.example.demo2.documents.StringGenerator")
    private String id;

    private Float campo;

    @Column(name = "ejeyid")
    private String ejeyId;

    public CamposY() {
    }

    public CamposY(String id, Float campo, String ejeyId) {
        this.id = id;
        this.campo = campo;
        this.ejeyId = ejeyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getCampo() {
        return campo;
    }

    public void setCampo(Float campo) {
        this.campo = campo;
    }

    public String getEjeyId() {
        return ejeyId;
    }

    public void setEjeyId(String ejeyId) {
        this.ejeyId = ejeyId;
    }

}