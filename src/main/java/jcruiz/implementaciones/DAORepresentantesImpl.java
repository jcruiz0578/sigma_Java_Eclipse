package jcruiz.implementaciones;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import jcruiz.db.DbConnection;
import jcruiz.interfaces.DAORepresentantes;
import jcruiz.models.Representantes;

public class DAORepresentantesImpl extends DbConnection implements DAORepresentantes {

	@Override
	public void registrar(Representantes representante) throws SQLException {
		
		try {
			
			this.Conectar();
	           
	           PreparedStatement st;
	          
	           st = this.getConexion().prepareStatement("insert INTO representantes  (cedularep, apellidosrep, nombresrep, sexorep, parentescorep,"
	           		+ " direccionrep, telefonosrep, emailrep, trabaja, lugartrabajo, sueldo) VALUES (?,?,?,?,?,?,?,?,?,?,?);");
	           
	           //Double id = estudiante.getCedulaest();
	           
	           st.setDouble(1, representante.getCedularep());
	           st.setString(2, representante.getApellidosrep());
	           st.setString(3, representante.getNombresrep());
	           st.setString(4, representante.getSexorep());
	           st.setString(5, representante.getParentescorep());
	           st.setString(6, representante.getDireccionrep());
	           st.setString(7, representante.getTelefonosrep());
	           st.setString(8, representante.getEmailrep());
	           st.setString(9, representante.getTrabaja());
	           st.setString(10, representante.getLugartrabajo());
	           st.setString(11, representante.getSueldo());
	        
	           
	           st.executeUpdate();
	           
	      
	       	
	       	
	       	
	           st.close();
	           
	           
	    	
		 } catch (SQLException | ClassNotFoundException e) {
	           throw new RuntimeException(e);
	       } finally{
	            this.Cerrar();
	        }
		
		
	}

	@Override
	public void modificar(Representantes representante) {
		// TODO Auto-generated method stub
		
	}

}
