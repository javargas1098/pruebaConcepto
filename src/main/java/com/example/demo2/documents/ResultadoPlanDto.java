package com.example.demo2.documents;

import java.io.Serializable;

public class ResultadoPlanDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String graficas;
    
    private String resultadoPlan;


    public String getGraficas() {
        return graficas;
    }

    public void setGraficas(String graficas) {
        this.graficas = graficas;
    }

    public String getResultadoPlan() {
        return resultadoPlan;
    }

    public void setResultadoPlan(String resultadoPlan) {
        this.resultadoPlan = resultadoPlan;
    }

 
}