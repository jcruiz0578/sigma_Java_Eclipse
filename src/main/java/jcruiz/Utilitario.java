package jcruiz;



import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

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
        
      
 public   void resizeColumnWidth(JTable table) {
     //Se obtiene el modelo de la columna
     TableColumnModel columnModel = table.getColumnModel();
     //Se obtiene el total de las columnas
     for (int column = 0; column < table.getColumnCount(); column++) {
         //Establecemos un valor minimo para el ancho de la columna
         int width = 100; //Min Width
         //Obtenemos el numero de filas de la tabla
         for (int row = 0; row < table.getRowCount(); row++) {
             //Obtenemos el renderizador de la tabla
             TableCellRenderer renderer = table.getCellRenderer(row, column);
             //Creamos un objeto para preparar el renderer
             Component comp = table.prepareRenderer(renderer, row, column);
             //Establecemos el width segun el valor maximo del ancho de la columna
             width = Math.max(comp.getPreferredSize().width + 1, width);

         }
         //Se establece una condicion para no sobrepasar el valor de 300
         //Esto es Opcional
//         if (width > 960) {
//             width = 960;
//         }
         //Se establece el ancho de la columna
         columnModel.getColumn(column).setPreferredWidth(width);
     }

	 
 }


}
