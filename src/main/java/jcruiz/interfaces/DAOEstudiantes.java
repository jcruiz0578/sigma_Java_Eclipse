package jcruiz.interfaces;

import java.sql.SQLException;
import java.util.List;

import jcruiz.models.Estudiantes;

public interface DAOEstudiantes {

    void registrar(Estudiantes estudiante) throws SQLException;
    void modificar(Estudiantes estudiante)throws SQLException;
    void eliminar(Estudiantes estudiante)throws SQLException;

    List<Estudiantes> listar() throws SQLException;


}
