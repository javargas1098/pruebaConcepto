package com.example.demo2.documents;

public enum Variables {
    GLOBAL(""), GRAFICAPLANIDGLOBAL(""), EJESGRAFICAIDGLOBAL(""), DATAEJEYIDGLOBAL("");

    String label;
    int var;

    private Variables(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public int getVar() {
        return var;
    }
}