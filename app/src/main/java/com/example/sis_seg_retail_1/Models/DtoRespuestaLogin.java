package com.example.sis_seg_retail_1.Models;

public class DtoRespuestaLogin {

    private String tipoIdentificacion;
    private String numIdentificacion;
    private String nombres;
    private String apellidos;
    private String rol;
    private String contrasegna;

    public DtoRespuestaLogin(String tipoIdentificacion, String numIdentificacion, String nombres, String apellidos, String rol, String contrasegna) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.numIdentificacion = numIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rol = rol;
        this.contrasegna = contrasegna;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContrasegna() {
        return contrasegna;
    }

    public void setContrasegna(String contrasegna) {
        this.contrasegna = contrasegna;
    }
}
