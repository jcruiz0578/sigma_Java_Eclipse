
package jcruiz.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jcruiz.db.DbConnection;
import jcruiz.interfaces.DAOUsers;
import jcruiz.models.Users;


public class DAOUsersImpl extends DbConnection implements DAOUsers{

    @Override
    public void registrar(Users user) throws Exception {
       try {
            this.Conectar();
            PreparedStatement st;
            st = this.getConexion().prepareStatement("insert INTO  users(login, name, password, categoria,status, email, created_at,updated_at) VALUES (?,?,?,?,?,?,?, ?);");
            //st.setInt(1,user.getId());
            st.setString(1, user.getLogin());
            st.setString(2, user.getName());
            st.setString(3, user.getPassword());
            st.setString(4, user.getCategoria());
            st.setString(5, user.getStatus());
            st.setString(6, user.getEmail());
            st.setString(7, user.getCreated_at());
            st.setString(8, user.getUpdated_at());
            st.executeUpdate();
            st.close();

        } catch (SQLException e) {
           throw new RuntimeException(e);
       } finally{
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Users user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Users user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Users> listar() throws SQLException, ClassNotFoundException {
       List<Users> lista;

        try {

            this.Conectar();
            PreparedStatement st;
            st = this.getConexion().prepareStatement("SELECT * FROM users");
            lista = new ArrayList<>();

            ResultSet rs =  st.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setName(rs.getString("name"));
                user.setCategoria(rs.getString("categoria"));
                user.setEmail(rs.getString("email"));
                lista.add(user);

            }

            rs.close();
            st.close();



        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw e;
            } finally{
            this.Cerrar();
        }
        return lista;
        }

    }




