package com.example.sis_seg_retail_1.Models;

public class DtoLogin {

    private String numIdentificacion;
    private String contrasegna;


    public DtoLogin() {
        this.contrasegna = contrasegna;
        this.numIdentificacion = numIdentificacion;
    }


    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getContrasegna() {
        return contrasegna;
    }

    public void setContrasegna(String contrasegna) {
        this.contrasegna = contrasegna;
    }
}
