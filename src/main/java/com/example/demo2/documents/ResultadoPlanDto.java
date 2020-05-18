package com.example.demo2.documents;

import java.io.Serializable;

public class ResultadoPlanDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String id;

    private String titulo;

    private String carId;

    private String tipoGrafica;

    private String nombreEjeX;

    private String nombreEjey;

    private String tipoDatos;

    String ejes;

    String dataEjeY;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getTipoGrafica() {
        return tipoGrafica;
    }

    public void setTipoGrafica(String tipoGrafica) {
        this.tipoGrafica = tipoGrafica;
    }

    public String getNombreEjeX() {
        return nombreEjeX;
    }

    public void setNombreEjeX(String nombreEjeX) {
        this.nombreEjeX = nombreEjeX;
    }

    public String getNombreEjey() {
        return nombreEjey;
    }

    public void setNombreEjey(String nombreEjey) {
        this.nombreEjey = nombreEjey;
    }

    public String getTipoDatos() {
        return tipoDatos;
    }

    public void setTipoDatos(String tipoDatos) {
        this.tipoDatos = tipoDatos;
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