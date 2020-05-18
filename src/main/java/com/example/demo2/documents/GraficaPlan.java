package com.example.demo2.documents;

import java.util.LinkedList;
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
@Table(name = "CR_GRAFICA")
public class GraficaPlan {
    @Id
    @GeneratedValue(generator = "prod-generator-activi")
    @GenericGenerator(name = "prod-generator-activi", parameters = @Parameter(name = "prefix", value = "Gp"), strategy = "com.example.demo2.documents.StringGenerator")
    private String id;

    private String titulo;
    @Column(name = "carid")
    private String carId;

    @Column(name = "tipo_grafica")
    private String tipoGrafica;

    @Column(name = "ejex")
    private String nombreEjeX;

    @Column(name = "ejey")
    private String nombreEjey;

    @Column(name = "tipo_datos")
    private String tipoDatos;

    @Transient
    List<Ejes> ejes = new LinkedList<>();

    @Transient
    List<DataEjeY> dataEjeY = new LinkedList<>();

    public GraficaPlan() {
    }

    public GraficaPlan(String id, String titulo, String carId, String tipoGrafica, String nombreEjeX, String nombreEjey,
            String tipoDatos) {
        this.id = id;
        this.titulo = titulo;
        this.carId = carId;
        this.tipoGrafica = tipoGrafica;
        this.nombreEjeX = nombreEjeX;
        this.nombreEjey = nombreEjey;
        this.tipoDatos = tipoDatos;
    }

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

    public String getTipoGrafica() {
        return tipoGrafica;
    }

    public void setTipoGrafica(String tipoGrafica) {
        this.tipoGrafica = tipoGrafica;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
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

    public List<Ejes> getEjes() {
        return ejes;
    }

    public void setEjes(List<Ejes> ejes) {
        this.ejes = ejes;
    }

    public List<DataEjeY> getDataEjeY() {
        return dataEjeY;
    }

    public void setDataEjeY(List<DataEjeY> dataEjeY) {
        this.dataEjeY = dataEjeY;
    }

}