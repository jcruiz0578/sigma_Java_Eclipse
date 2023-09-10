package jcruiz.interfaces;

import java.sql.SQLException;
import java.util.List;

import jcruiz.models.Ingresos;

public interface DAOIngresos {

   

	void registrar(Ingresos ingreso) throws SQLException;
    void modificar(Ingresos ingreso);
    
    void eliminar(Ingresos ingreso);

    List<Ingresos> listar() throws SQLException;
    
    List<Ingresos> listarHistorial(Double Cedulaest) throws SQLException;
    
   //Buscar datos del Estudiante
    public Ingresos getIdCed(Double Cedulaest) throws SQLException;
    
    // comprobación de petenencia al año escolar actual
    public Ingresos getComprobacionPeriodoescolar(Double Cedulaest, String periodoEscolarActual) throws SQLException;
    
    
 
    
    
    
   


}
