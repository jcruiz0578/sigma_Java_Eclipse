package jcruiz.db;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DbConnection {

    private Connection conexion;


    public void Conectar() throws ClassNotFoundException {

        try {
            String DB_URL = "jdbc:mariadb://localhost:3306/liceo";
            String USER = "jcruiz";
            String PASS = "123456";
            setConexion(DriverManager.getConnection(DB_URL, USER, PASS));
            String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
            Class.forName(JDBC_DRIVER);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "NO SE PUEDE ESTABLECER CONEXION CON EL SERVIDOR", "ERROR DE CONEXION..", JOptionPane.ERROR_MESSAGE);
        }
    }

public void Cerrar() throws SQLException {
        if(getConexion() != null){
            if(!getConexion().isClosed()){
                getConexion().close();
            }
        }
}

public Connection getConexion() {
	return conexion;
}

public void setConexion(Connection conexion) {
	this.conexion = conexion;
}



}
