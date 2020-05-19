package com.example.demo2.documents;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = " CR_DATA_EJEY")
public class DataEjeY {
    @Id
    @GeneratedValue(generator = "prod-generator-activi")
    @GenericGenerator(name = "prod-generator-activi", parameters = @Parameter(name = "prefix", value = "DtY"), strategy = "com.example.demo2.documents.StringGenerator")
    private String id;

    @Column(name = "nombre_eje")
    private String nombreEje;

    @Column(name = "ejeyid")
    private String ejeyId;

    @Transient
    List<Float> puntosY;

    public DataEjeY() {
    }

    public DataEjeY(String id, String nombreEje) {
        this.id = id;
        this.nombreEje = nombreEje;
    }

    public DataEjeY(String id, String nombreEje, String ejeyId) {
        this.id = id;
        this.nombreEje = nombreEje;
        this.ejeyId = ejeyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEjeyId() {
        return ejeyId;
    }

    public void setEjeyId(String ejeyId) {
        this.ejeyId = ejeyId;
    }

    public String getNombreEje() {
        return nombreEje;
    }

    public void setNombreEje(String nombreEje) {
        this.nombreEje = nombreEje;
    }

    public List<Float> getPuntosY() {
        return puntosY;
    }

    public void setPuntosY(List<Float> puntosY) {
        this.puntosY = puntosY;
    }

}