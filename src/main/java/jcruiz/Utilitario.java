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
	private static String periodoescolar;
		
	
	/*ALMACENA Y OBTIENE L PERIODO ESCOLAR ACTUAL*/
	
	public void setPeriodoescolar(String periodoescolar) {
		Utilitario.periodoescolar = periodoescolar;
		
	}
	
	    public String getPeriodoescolar() {
		return periodoescolar;
	}


	    /* TIPO  Y TAMAÑO DE LETRAS  DE LA CARPETA FONT EN RESOURCES */
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
        
        
        /*LLENA EL JCOMBOX  DE LOS PLANTELES*/
		
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
        
        
        /*LLENA EL JCOMBOX  DE LOS ESTADOS*/
        
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


        	/* OBTIENE EL MES DE LA FECHA DE INGRESO SUMINISTRADA*/
		
        public String obtenerMesIngreso(String fechaIns) {
        	
        	String mes = null;        

            String valormes1 = fechaIns.substring(5, 7);

            if (valormes1.equals("01")) {

                mes = "ENERO";
            }

            if (valormes1.equals("02")) {

                mes = "FEBRERO";

            }

            if (valormes1.equals("03")) {

                mes = "MARZO";

            }

            if (valormes1.equals("04")) {

                mes = "ABRIL";
            }

            if (valormes1.equals("05")) {

                mes = "MAYO";

            }
            if (valormes1.equals("06")) {

                mes = "JUNIO";
            }

            if (valormes1.equals("07")) {

                mes = "JULIO";
            }

            if (valormes1.equals("08")) {

                mes = "AGOSTO";
            }

            if (valormes1.equals("09")) {

                mes = "SEPTIEMBRE";

            }

            if (valormes1.equals("10")) {

                mes = "OCTUBRE";
            }

            if (valormes1.equals("11")) {

                mes = "NOVIEMBRE";
            }

            if (valormes1.equals("12")) {

                mes = "DICIEMBRE";
            }

        	
			return mes;
        	
        }
        
      
    	        


}
