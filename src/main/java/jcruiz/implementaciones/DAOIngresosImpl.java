package jcruiz.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jcruiz.Utilitario;
import jcruiz.db.DbConnection;
import jcruiz.interfaces.DAOIngresos;
import jcruiz.models.Ingresos;

public class DAOIngresosImpl extends DbConnection implements DAOIngresos {
	
	public void registrar(Ingresos ingreso) throws SQLException {
		
		try {
			 this.Conectar();
		        
		        PreparedStatement st;
             
       
            st = this.getConexion().prepareStatement("insert INTO ingresos  (id_ingreso, periodoescolar, sw_prosecucion, cedulaest, condicionest, materiapendiente, anoest, seccion, cedularep,"
            		+ "fecha_ingreso, mes_ingreso, fechasistema, status, observacion, inscriptor, ficha, nombre_plantel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            
           // Double cedula = estudiante.getCedulaest();
           // String id_ingreso = "2023-2024"+cedula+"I";
            
          
            
            st.setString(1, ingreso.getId_ingreso());
            st.setString(2,ingreso.getPeriodoescolar());
            st.setString(3, "SI");
            st.setDouble(4, ingreso.getCedulaest());
            st.setString(5,ingreso.getCondicionest());
            st.setString(6,ingreso.getMateriapendiente());
            st.setString(7, ingreso.getAnoest());
            st.setString(8, ingreso.getSecion());
            st.setInt(9, ingreso.getCedularep());
            st.setString(10, ingreso.getFecha_ingreso());
            st.setString(11, ingreso.getMes_ingreso());
            st.setString(12, ingreso.getFechasistema());
            st.setString(13, ingreso.getStatus());
            st.setString(14, ingreso.getObservacion());
            st.setString(15, ingreso.getInscriptor());
            st.setString(16, ingreso.getFicha());
            st.setString(17, ingreso.getNombre_plantel());
            
            
                      
            
            st.executeUpdate();
       
            
            
            
            st.close();
            
            
        } catch (SQLException | ClassNotFoundException e) {
           throw new RuntimeException(e);
       } finally{
            this.Cerrar();
        }
		
		
		
		

	}

	@Override
	public void modificar(Ingresos ingreso) {

	}

	@Override
	public void eliminar(Ingresos ingreso) {

	}

	@Override
	public List<Ingresos> listar() throws SQLException {
		List<Ingresos> lista;
		try {

			this.Conectar();
			
			String periodoescolar = (new Utilitario().getPeriodoescolar()).trim();

			PreparedStatement st = this.getConexion().prepareStatement(
					"SELECT *  FROM  estudiantes,ingresos WHERE ingresos.periodoescolar =  '" + periodoescolar + "' &&  estudiantes.cedulaest = ingresos.cedulaest   order by anoest, fnest DESC");
			lista = new ArrayList<>();

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Ingresos ing = new Ingresos();

				ing.setId_ingreso(rs.getString("id_ingreso"));
				ing.setPeriodoescolar(rs.getString("periodoescolar"));
				ing.setCedulaest(rs.getDouble("cedulaest"));
				ing.setApellidosest(rs.getString("apellidosest"));
				ing.setNombresest(rs.getString("nombresest"));
				ing.setSexoest(rs.getString("sexoest"));
				ing.setLateralidad(rs.getString("lateralidad"));
				ing.setFnest(rs.getString("fnest"));
				ing.setOrden_nac(rs.getInt("orden_nac"));
				ing.setEstado_nac(rs.getString("estado_nac"));
				ing.setLugar_nac(rs.getString("lugar_nac"));
				ing.setEstado_civil(rs.getString("estado_civil"));
				ing.setDireccionest(rs.getString("direccionest"));
				ing.setTelefonoest(rs.getString("telefonosest"));
				ing.setEmailest(rs.getString("emailest"));
				ing.setNombre_plantel(rs.getString("nombre_plantel"));
				ing.setCondicionest(rs.getString("condicionest"));
				ing.setAnoest(rs.getString("anoest"));
				ing.setSecion(rs.getString("seccion"));
				ing.setFecha_ingreso(rs.getString("fecha_ingreso"));
				ing.setStatus(rs.getString("status"));
				ing.setObservacion(rs.getString("observacion"));
				ing.setInscriptor(rs.getString("inscriptor"));
				ing.setFicha(rs.getString("ficha"));
				ing.setNum_reg(rs.getInt("num_reg"));

				lista.add(ing);

			}

			rs.close();
			st.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);

		} finally {
			this.Cerrar();
		}

		return lista;

	}

	
	
	

	
	
}
