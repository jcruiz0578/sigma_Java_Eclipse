package jcruiz.models;


import java.text.DecimalFormat;
import java.util.Date;

public class Estudiantes {

    private Double cedulaest;
    private String apellidosest;
    private String nombresest;
    private String sexoest;
    private String lateralidad;
    private Date fnest;
    private int orden_nac;
    private String estado_nac;
    private String lugar_nac;
    private String estado_civil;
    private String direccionest;
    private String telefonoest;
    private String emailest;
    private String nombre_plantel;






    public Double getCedulaest() {

        return    cedulaest;
    }

    public String getCedulaestFormateada(){

        Double cedulaformateada = getCedulaest();

        DecimalFormat formato = new DecimalFormat("#");

        return formato.format(cedulaformateada);

    }



    public void setCedulaest(Double cedulaest) {
        this.cedulaest = cedulaest;
    }






    public String getApellidosest() {
        return apellidosest;
    }

    public void setApellidosest(String apellidosest) {
        this.apellidosest = apellidosest;
    }

    public String getNombresest() {
        return nombresest;
    }

    public void setNombresest(String nombresest) {
        this.nombresest = nombresest;
    }





    public String getNombreCompleto() {
        return getApellidosest() + ",  " + getNombresest();
    }





    public String getSexoest() {
        return sexoest;
    }

    public void setSexoest(String sexoest) {
        this.sexoest = sexoest;
    }

    public String getLateralidad() {
        return lateralidad;
    }

    public void setLateralidad(String lateralidad) {
        this.lateralidad = lateralidad;
    }

    public Date getFnest() {
        return fnest;
    }

    public void setFnest(Date fnest) {
        this.fnest = fnest;
    }

    public int getOrden_nac() {
        return orden_nac;
    }

    public void setOrden_nac(int orden_nac) {
        this.orden_nac = orden_nac;
    }

    public String getEstado_nac() {
        return estado_nac;
    }

    public void setEstado_nac(String estado_nac) {
        this.estado_nac = estado_nac;
    }

    public String getLugar_nac() {
        return lugar_nac;
    }

    public void setLugar_nac(String lugar_nac) {
        this.lugar_nac = lugar_nac;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getDireccionest() {
        return direccionest;
    }

    public void setDireccionest(String direccionest) {
        this.direccionest = direccionest;
    }

    public String getTelefonoest() {
        return telefonoest;
    }

    public void setTelefonoest(String telefonoest) {
        this.telefonoest = telefonoest;
    }

    public String getEmailest() {
        return emailest;
    }

    public void setEmailest(String emailest) {
        this.emailest = emailest;
    }

    public String getNombre_plantel() {
        return nombre_plantel;
    }

    public void setNombre_plantel(String nombre_plantel) {
        this.nombre_plantel = nombre_plantel;
    }
}