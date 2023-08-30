package jcruiz.interfaces;

import java.sql.SQLException;
import java.util.List;

import jcruiz.models.Estudiantes;

public interface DAOEstudiantes {

    void registrar(Estudiantes estudiantes);
    void modificar(Estudiantes estudiantes);
    void eliminar(Estudiantes estudiantes);

    List<Estudiantes> listar() throws SQLException;


}
