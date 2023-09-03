package jcruiz.implementaciones;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import jcruiz.db.DbConnection;
import jcruiz.interfaces.DAOViviendas;
import jcruiz.models.Viviendas;

public class DAOViviendasImpl extends DbConnection implements DAOViviendas{

	@Override
	public void registrar(Viviendas vivienda) throws SQLException {
		
		
		try {
			 this.Conectar();
		        
		        PreparedStatement st;
            
      
           st = this.getConexion().prepareStatement("insert INTO vivienda  (id_ingreso, tipovia, direccionest, zonaubicacion, tipovivienda, ubicacionvivienda, condicionvivienda, infraestructura ) VALUES (?,?,?,?,?,?,?,?);");
           
            
         
           
           st.setString(1, vivienda.getId_ingreso());
           st.setString(2,vivienda.getTipovia());
           st.setString(3, vivienda.getDireccionest());
           st.setString(4, vivienda.getZonaubicacion());
           st.setString(5, vivienda.getTipovivienda());
           st.setString(6, vivienda.getUbicacionvivienda());
           st.setString(7, vivienda.getCondicionvivienda());
           st.setString(8, vivienda.getInfraestructura());
           
                     
           
           st.executeUpdate();
      
           
           
           
           st.close();
           
           
       } catch (SQLException | ClassNotFoundException e) {
          throw new RuntimeException(e);
      } finally{
           this.Cerrar();
       }
		
		
		
		
		
		
		
		
	}

	@Override
	public void modificar(Viviendas vivienda) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
