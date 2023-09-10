package jcruiz.models;

import java.text.DecimalFormat;

public class Representantes {
	
	private int cedularep;
    private String apellidosrep;
    private String nombresrep;
    private String sexorep;
    private String parentescorep;
    private String direccionrep;
    private String telefonosrep;
    private String emailrep;
    private String trabaja;
    private String lugartrabajo;
    private String sueldo;
    
	public int getCedularep() {
		return cedularep;
	}
	
	
	 public String getCedulaestFormateada(){

	        int cedulaformateada = getCedularep();

	        DecimalFormat formato = new DecimalFormat("#");

	        return formato.format(cedulaformateada);

	    }
	
	
	
	
	
	
	
	public void setCedularep(int cedularep) {
		this.cedularep = cedularep;
	}
	public String getApellidosrep() {
		return apellidosrep;
	}
	public void setApellidosrep(String apellidosrep) {
		this.apellidosrep = apellidosrep;
	}
	public String getNombresrep() {
		return nombresrep;
	}
	public void setNombresrep(String nombresrep) {
		this.nombresrep = nombresrep;
	}
	public String getSexorep() {
		return sexorep;
	}
	public void setSexorep(String sexorep) {
		this.sexorep = sexorep;
	}
	public String getParentescorep() {
		return parentescorep;
	}
	public void setParentescorep(String parentescorep) {
		this.parentescorep = parentescorep;
	}
	public String getDireccionrep() {
		return direccionrep;
	}
	public void setDireccionrep(String direccionrep) {
		this.direccionrep = direccionrep;
	}
	public String getTelefonosrep() {
		return telefonosrep;
	}
	public void setTelefonosrep(String telefonosrep) {
		this.telefonosrep = telefonosrep;
	}
	public String getEmailrep() {
		return emailrep;
	}
	public void setEmailrep(String emailrep) {
		this.emailrep = emailrep;
	}
	public String getTrabaja() {
		return trabaja;
	}
	public void setTrabaja(String trabaja) {
		this.trabaja = trabaja;
	}
	public String getLugartrabajo() {
		return lugartrabajo;
	}
	public void setLugartrabajo(String lugartrabajo) {
		this.lugartrabajo = lugartrabajo;
	}
	public String getSueldo() {
		return sueldo;
	}
	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}
	

    
    
}
