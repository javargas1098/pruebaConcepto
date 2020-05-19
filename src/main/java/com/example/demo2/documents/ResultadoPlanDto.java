package com.example.demo2.documents;

import java.io.Serializable;

public class ResultadoPlanDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String graficas;

    String ejes;

    String dataEjeY;

    public String getGraficas() {
        return graficas;
    }

    public void setGraficas(String graficas) {
        this.graficas = graficas;
    }

    public String getEjes() {
        return ejes;
    }

    public void setEjes(String ejes) {
        this.ejes = ejes;
    }

    public String getDataEjeY() {
        return dataEjeY;
    }

    public void setDataEjeY(String dataEjeY) {
        this.dataEjeY = dataEjeY;
    }

 
}