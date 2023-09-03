package jcruiz.interfaces;

import java.sql.SQLException;

import jcruiz.models.Representantes;

public interface DAORepresentantes {
	void registrar(Representantes representante) throws SQLException;
    void modificar(Representantes representante)throws SQLException;
}
