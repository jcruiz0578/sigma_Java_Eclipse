package jcruiz;


import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import jcruiz.db.DbConnection;

public class Utilitario {



        public Font tipoLetra(String tipoFont, int tamanoFont) throws IOException, FontFormatException {


            Font fuente;
            InputStream myStream = null;

            myStream = getClass().getResourceAsStream("/Font/"+tipoFont+".ttf");
            assert myStream != null;
            fuente = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fuente = fuente.deriveFont(Font.PLAIN, tamanoFont);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fuente);


            return fuente;
        }
        
        
        
        public void llenar_plantel(JComboBox<Object> combox) {
    		DbConnection bd = new DbConnection();
    		Statement st;
    				try {
    					bd.Conectar();
    		
    		st = bd.getConexion().createStatement();
    		
    		ResultSet res = st.executeQuery(
    				"SELECT id_procedencia, nombre_plantel  FROM  instituciones");
    		 while(res.next()){
    	            combox.addItem(res.getString("nombre_plantel"));
    	        }
    		
    		
    				} catch (ClassNotFoundException | SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}

    		
    		
    	}
        
        
        
        public void llenar_estados(JComboBox<Object> combox) {
        	DbConnection bd = new DbConnection();
    		Statement st;
    				try {
    					bd.Conectar();
    		
    		st = bd.getConexion().createStatement();
    		
    		ResultSet res = st.executeQuery(
    				"SELECT id, nombre  FROM  ubicacion_estado");
    		 while(res.next()){
    	            combox.addItem(res.getString("nombre"));
    	        }
    		
    		
    				} catch (ClassNotFoundException | SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}

    		
    		
    	}
        
      
    	        


}
