package jcruiz.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jcruiz.db.DbConnection;
import jcruiz.interfaces.DAOEstudiantes;
import jcruiz.models.Estudiantes;

public class DAOEstudiantesImpl extends DbConnection implements DAOEstudiantes {

    @Override
    public void registrar(Estudiantes estudiante) throws SQLException {

       try {
		
    	   this.Conectar();
           
           PreparedStatement st;
          
           st = this.getConexion().prepareStatement("insert INTO estudiantes  (cedulaest, apellidosest, nombresest, sexoest, lateralidad, fnest, orden_nac, estado_nac, lugar_nac, estado_civil,"
           		+ " direccionest, telefonosest, emailest, nombre_plantel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
           
           //Double id = estudiante.getCedulaest();
           
           st.setDouble(1, estudiante.getCedulaest());
           st.setString(2, estudiante.getApellidosest());
           st.setString(3, estudiante.getNombresest());
           st.setString(4, estudiante.getSexoest());
           st.setString(5, estudiante.getLateralidad());
           st.setString(6,   estudiante.getFnest());
           st.setInt(7, estudiante.getOrden_nac());
           st.setString(8, estudiante.getEstado_nac());
           st.setString(9, estudiante.getLugar_nac());
           st.setString(10, estudiante.getEstado_civil());
           st.setString(11, estudiante.getDireccionest());
           st.setString(12, estudiante.getTelefonoest());
           st.setString(13, estudiante.getEmailest());
           st.setString(14, estudiante.getNombre_plantel());
           
           st.executeUpdate();
           st.close();
           
           this.Cerrar();
    	   
    	   
    	   
    	   
       } catch (SQLException | ClassNotFoundException e) {
           throw new RuntimeException(e);
       } finally{
            this.Cerrar();
        }
    	
      
    	
    	
    }

    @Override
    public void modificar(Estudiantes estudiantes) {

    }

    @Override
    public void eliminar(Estudiantes estudiantes) {

    }

    @Override
    public List<Estudiantes> listar() throws SQLException {
        List<Estudiantes> lista;
        try {

            this.Conectar();
            PreparedStatement st = this.getConexion().prepareStatement("SELECT * FROM estudiantes");
            lista = new ArrayList<>();

            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Estudiantes est = new Estudiantes();

                est.setCedulaest(rs.getDouble("cedulaest"));
                est.setApellidosest(rs.getString("apellidosest"));
                est.setNombresest(rs.getString("nombresest"));
                est.setSexoest(rs.getString("sexoest"));
                est.setLateralidad(rs.getString("lateralidad"));
                est.setFnest(rs.getString("fnest"));
                est.setOrden_nac(rs.getInt("orden_nac"));
                est.setEstado_nac(rs.getString("estado_nac"));
                est.setLugar_nac(rs.getString("lugar_nac"));
                est.setEstado_civil(rs.getString("estado_civil"));
                est.setDireccionest(rs.getString("direccionest"));
                est.setTelefonoest(rs.getString("telefonosest"));
                est.setTelefonoest(rs.getString("emailest"));
                est.setNombre_plantel((rs.getString("nombre_plantel")));
                lista.add(est);

            }

            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);

        }finally {
            this.Cerrar();
        }

        return lista;
    }

}
