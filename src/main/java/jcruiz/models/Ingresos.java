package jcruiz.models;

import java.text.DecimalFormat;
import java.util.Date;

public class Ingresos extends Estudiantes {
    private String id_ingreso;
    private String periodoescolar;
    private String sw_prosecucion;
    private Double cedulaest;  // id de la tabla estudiantes
    private String condicionest;
    private String repitienteest;
    private String materiapendiente;
    private String mp_nombres;
    private String rezagado;
    private String nuevo_ingreso;
    private String anoest;
    private String secion;
    private int cedularep; // Id de la table representantes
    private String fecha_ingreso;
    private String mes_ingreso;
    private String fechasistema;
    private String reinscripcion;
    private Date fechareinscripcion;
    private String tipoinscripcion;
    private String status;
    private String observacion;
    private String inscriptor;
    private String ficha;
    private String nombre_plantel;
    private int num_reg;
    
    

//    private String nombres_apellidos; // para enlazar con tabla estudintes



   // getter y setter


    public String getId_ingreso() {
        return id_ingreso;
    }

    public void setId_ingreso(String id_ingreso) {
        this.id_ingreso = id_ingreso;
    }

    public String getPeriodoescolar() {
        return periodoescolar;
    }

    public void setPeriodoescolar(String periodoescolar) {
        this.periodoescolar = periodoescolar;
    }

    public String getSw_prosecucion() {
        return sw_prosecucion;
    }

    public void setSw_prosecucion(String sw_prosecucion) {
        this.sw_prosecucion = sw_prosecucion;
    }

    @Override
	public Double getCedulaest() {
        return cedulaest;
    }

    @Override
	public void setCedulaest(Double cedulaest) {
        this.cedulaest = cedulaest;
    }


    @Override
	public String getCedulaestFormateada(){

        Double cedulaformateada = getCedulaest();

        DecimalFormat formato = new DecimalFormat("#");

        return formato.format(cedulaformateada);

    }


    public String getCondicionest() {
        return condicionest;
    }

    public void setCondicionest(String condicionest) {
        this.condicionest = condicionest;
    }

    public String getRepitienteest() {
        return repitienteest;
    }

    public void setRepitienteest(String repitienteest) {
        this.repitienteest = repitienteest;
    }

    public String getMateriapendiente() {
        return materiapendiente;
    }

    public void setMateriapendiente(String materiapendiente) {
        this.materiapendiente = materiapendiente;
    }

    public String getMp_nombres() {
        return mp_nombres;
    }

    public void setMp_nombres(String mp_nombres) {
        this.mp_nombres = mp_nombres;
    }

    public String getRezagado() {
        return rezagado;
    }

    public void setRezagado(String rezagado) {
        this.rezagado = rezagado;
    }

    public String getNuevo_ingreso() {
        return nuevo_ingreso;
    }

    public void setNuevo_ingreso(String nuevo_ingreso) {
        this.nuevo_ingreso = nuevo_ingreso;
    }

    public String getAnoest() {
        return anoest;
    }

    public void setAnoest(String anoest) {
        this.anoest = anoest;
    }

    public String getSecion() {
        return secion;
    }

    public void setSecion(String secion) {
        this.secion = secion;
    }

    public int getCedularep() {
        return cedularep;
    }

    public void setCedularep(int cedularep) {
        this.cedularep = cedularep;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String string) {
        this.fecha_ingreso = string;
    }

    public String getMes_ingreso() {
        return mes_ingreso;
    }

    public void setMes_ingreso(String mes_ingreso) {
        this.mes_ingreso = mes_ingreso;
    }

    public String getFechasistema() {
        return fechasistema;
    }

    public void setFechasistema(String fechaSistema) {
        this.fechasistema = fechaSistema;
    }

    public String getReinscripcion() {
        return reinscripcion;
    }

    public void setReinscripcion(String reinscripcion) {
        this.reinscripcion = reinscripcion;
    }

    public Date getFechareinscripcion() {
        return fechareinscripcion;
    }

    public void setFechareinscripcion(Date fechareinscripcion) {
        this.fechareinscripcion = fechareinscripcion;
    }

    public String getTipoinscripcion() {
        return tipoinscripcion;
    }

    public void setTipoinscripcion(String tipoinscripcion) {
        this.tipoinscripcion = tipoinscripcion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getInscriptor() {
        return inscriptor;
    }

    public void setInscriptor(String inscriptor) {
        this.inscriptor = inscriptor;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    @Override
	public String getNombre_plantel() {
        return nombre_plantel;
    }

    @Override
	public void setNombre_plantel(String nombre_plantel) {
        this.nombre_plantel = nombre_plantel;
    }

    public int getNum_reg() {
        return num_reg;
    }

    public void setNum_reg(int num_reg) {
        this.num_reg = num_reg;
    }

	


}
