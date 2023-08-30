package jcruiz.interfaces;

import java.sql.SQLException;
import java.util.List;

import jcruiz.models.Users;

public interface DAOUsers {
    void registrar(Users user)throws Exception;
    void modificar(Users user);
    void eliminar(Users user);
    List<Users> listar() throws SQLException, ClassNotFoundException;

}
