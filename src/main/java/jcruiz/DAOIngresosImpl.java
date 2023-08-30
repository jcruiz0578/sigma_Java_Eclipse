package jcruiz;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import jcruiz.db.DbConnection;
import jcruiz.interfaces.DAOIngresos;
import jcruiz.models.Estudiantes;
import jcruiz.models.Ingresos;

public class DAOIngresosImpl extends DbConnection implements DAOIngresos {
	
	public void registar(Estudiantes estudiante,Ingresos ingreso) throws SQLException {
		
		try {
            this.Conectar();
          
            PreparedStatement st;
           
            st = this.getConexion().prepareStatement("insert INTO Estudiantes  (cedulaest, apellidosest, nombresest, sexoest, lateralidad, fnest, orden_nac, estado_nac, lugar_nac, estado_civil,"
            		+ " direccionest, telefonoest, emailest, nombre_plantel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            
            //Double id = estudiante.getCedulaest();
            
            st.setDouble(1, estudiante.getCedulaest());
            st.setString(2, estudiante.getApellidosest());
            st.setString(3, estudiante.getNombresest());
            st.setString(4, estudiante.getSexoest());
            st.setString(5, estudiante.getLateralidad());
            st.setDate(6,  (Date) estudiante.getFnest());
            st.setInt(7, estudiante.getOrden_nac());
            st.setString(8, estudiante.getEstado_nac());
            st.setString(9, estudiante.getLugar_nac());
            st.setString(10, estudiante.getEstado_civil());
            st.setString(11, estudiante.getDireccionest());
            st.setString(12, estudiante.getTelefonoest());
            st.setString(13, estudiante.getEmailest());
            st.setString(14, estudiante.getNombre_plantel());
            
            st.executeUpdate();
            
            
       
            st = this.getConexion().prepareStatement("insert INTO Ingresos  (id_ingreso, periodoescolar, sw_prosecusion, cedulaest, condicionest, materiapendiente, anoest, seccion,"
            		+ "fecha_ingreso, mes_ingreso, fechasistema, status, observacion, inscriptor, ficha, nombre_plantel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            
            //Double id = estudiante.getCedulaest();
            
            st.setDouble(1, estudiante.getCedulaest());
            
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

			PreparedStatement st = this.getConexion().prepareStatement(
					"SELECT *  FROM  estudiantes,ingresos WHERE ingresos.periodoescolar =  '2022-2023' &&  estudiantes.cedulaest = ingresos.cedulaest   order by anoest, fnest DESC");
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
				ing.setFnest(rs.getDate("fnest"));
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
				ing.setFecha_ingreso(rs.getDate("fecha_ingreso"));
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
