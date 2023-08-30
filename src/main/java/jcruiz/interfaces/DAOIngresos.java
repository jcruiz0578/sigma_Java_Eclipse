package jcruiz.interfaces;

import java.sql.SQLException;
import java.util.List;

import jcruiz.models.Estudiantes;
import jcruiz.models.Ingresos;

public interface DAOIngresos {

   

	void registar(Estudiantes estudiante,Ingresos ingreso) throws SQLException;
    void modificar(Ingresos ingreso);
    
    void eliminar(Ingresos ingreso);

    List<Ingresos> listar() throws SQLException;
    
 
    
    
    
   


}
