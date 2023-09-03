package jcruiz.interfaces;

import java.sql.SQLException;


import jcruiz.models.Viviendas;

public interface DAOViviendas {
	void registrar(Viviendas vivienda) throws SQLException;
    void modificar(Viviendas vivienda)throws SQLException;
}
