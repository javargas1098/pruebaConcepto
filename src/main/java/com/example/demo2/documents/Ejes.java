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
@Table(name = "CR_EJES_GRAFICA")
public class Ejes {
    @Id
    @GeneratedValue(generator = "prod-generator-activi")
    @GenericGenerator(name = "prod-generator-activi", parameters = @Parameter(name = "prefix", value = "E"), strategy = "com.example.demo2.documents.StringGenerator")
    private String id;

    @Column(name = "tipo_grafica")
    private String graficaId;

    private String eje;

    @Transient
    List<String> campos;

    public Ejes() {
    }

    public Ejes(String id, String eje) {
        this.id = id;
        this.eje = eje;
    }

    public Ejes(String id, String graficaId, String eje) {
        this.id = id;
        this.graficaId = graficaId;
        this.eje = eje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGraficaId() {
        return graficaId;
    }

    public void setGraficaId(String graficaId) {
        this.graficaId = graficaId;
    }

    public String getEje() {
        return eje;
    }

    public void setEje(String eje) {
        this.eje = eje;
    }

    public List<String> getCampos() {
        return campos;
    }

    public void setCampos(List<String> campos) {
        this.campos = campos;
    }

}