package jcruiz.views.ingresos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import jcruiz.Utilitario;
import jcruiz.implementaciones.DAOIngresosImpl;
import jcruiz.interfaces.DAOIngresos;
import jcruiz.models.Ingresos;

public class IngresoPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;

	 JTable tableIngresos = new JTable();
	 private JScrollPane JScrollPanel1;
	 private JPanel panel;
	 private JComboBox<Object> comboSeccion;
	 private JLabel lblNewLabel;
	 private JTextField textCedula;
	 private JComboBox<Object> comboStatus;
	 private JComboBox<Object> comboAnoEst;
	 private JPanel principal;
	 private JTextField textField;
	 private Component horizontalStrut;

	public JPanel getPrincipal() {
		return principal;
	}


	/**
	 * Create the panel.
	 */
	public IngresoPrincipal() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));

		principal = new JPanel();
		principal.setPreferredSize(new Dimension(1024, 600));
		principal.setBackground(new Color(255, 255, 255));
		principal.setBorder(new EmptyBorder(5, 10, 20, 10));
		add(principal, BorderLayout.CENTER);
		principal.setLayout(new BorderLayout(0, 0));

		JScrollPanel1 = new JScrollPane();
		JScrollPanel1.setMinimumSize(new Dimension(10, 10));
		JScrollPanel1.setBackground(new Color(255, 255, 255));
		principal.add(JScrollPanel1, BorderLayout.CENTER);



	     InicioTabla();
	      LoadIngresos();
	      new Utilitario().resizeColumnWidth(tableIngresos);

	        JPanel botonera = new JPanel();
	        botonera.setBackground(new Color(255, 255, 255));
	        principal.add(botonera, BorderLayout.SOUTH);
	        GridBagLayout gbl_botonera = new GridBagLayout();
	        gbl_botonera.columnWidths = new int[]{100, 110, 102, 92, 124, 0};
	        gbl_botonera.rowHeights = new int[]{0, 0};
	        gbl_botonera.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
	        gbl_botonera.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	        botonera.setLayout(gbl_botonera);
	        
	        comboAnoEst = new JComboBox<Object>();
	        comboAnoEst.setModel(new DefaultComboBoxModel<Object>(new String[] {"N/A", "1ER AÑO", "2DO AÑO", "3ER AÑO", "4TO AÑO CS", "5TO AÑO CS"}));
	        comboAnoEst.setName("");
	        comboAnoEst.setBorder(new TitledBorder(null, "A\u00F1o Est.:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	        comboAnoEst.setBackground(Color.WHITE);
	        GridBagConstraints gbc_comboAnoEst = new GridBagConstraints();
	        gbc_comboAnoEst.fill = GridBagConstraints.HORIZONTAL;
	        gbc_comboAnoEst.insets = new Insets(0, 0, 0, 5);
	        gbc_comboAnoEst.gridx = 0;
	        gbc_comboAnoEst.gridy = 0;
	        botonera.add(comboAnoEst, gbc_comboAnoEst);
	        
	        comboStatus = new JComboBox<Object>();
	        comboStatus.setModel(new DefaultComboBoxModel<Object>(new String[] {"N/A", "I", "E"}));
	        comboStatus.setName("");
	        comboStatus.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "- Estatus: -", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
	        comboStatus.setBackground(Color.WHITE);
	        GridBagConstraints gbc_comboStatus = new GridBagConstraints();
	        gbc_comboStatus.fill = GridBagConstraints.HORIZONTAL;
	        gbc_comboStatus.insets = new Insets(0, 0, 0, 5);
	        gbc_comboStatus.gridx = 1;
	        gbc_comboStatus.gridy = 0;
	        botonera.add(comboStatus, gbc_comboStatus);
	        
	        textField = new JTextField();
	        textField.setFont(new Font("Dialog", Font.BOLD, 14));
	        textField.setColumns(10);
	        textField.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "- C\u00E9dula: -", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
	        GridBagConstraints gbc_textField = new GridBagConstraints();
	        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
	        gbc_textField.insets = new Insets(0, 0, 0, 5);
	        gbc_textField.gridx = 2;
	        gbc_textField.gridy = 0;
	        botonera.add(textField, gbc_textField);
	        
	        horizontalStrut = Box.createHorizontalStrut(20);
	        GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
	        gbc_horizontalStrut.fill = GridBagConstraints.HORIZONTAL;
	        gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
	        gbc_horizontalStrut.gridx = 3;
	        gbc_horizontalStrut.gridy = 0;
	        botonera.add(horizontalStrut, gbc_horizontalStrut);

	        panel = new JPanel();
	        panel.setBackground(new Color(255, 255, 255));
	        principal.add(panel, BorderLayout.NORTH);
	        GridBagLayout gbl_panel = new GridBagLayout();
	        gbl_panel.columnWidths = new int[]{273, 273, 273, 0, 0};
	        gbl_panel.rowHeights = new int[]{0, 0, 0};
	        gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
	        gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	        panel.setLayout(gbl_panel);

	        lblNewLabel = new JLabel("Operaciones  Matriculares");
	        lblNewLabel.setBackground(new Color(255, 255, 255));
	        lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
	        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
	        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	        gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
	        gbc_lblNewLabel.gridwidth = 4;
	        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
	        gbc_lblNewLabel.gridx = 0;
	        gbc_lblNewLabel.gridy = 0;
	        panel.add(lblNewLabel, gbc_lblNewLabel);

	        textCedula = new JTextField();
	        textCedula.setHorizontalAlignment(SwingConstants.RIGHT);
	        textCedula.setFont(new Font("Dialog", Font.BOLD, 14));
	        textCedula.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "- C\u00E9dula: -", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
	        GridBagConstraints gbc_textCedula = new GridBagConstraints();
	        gbc_textCedula.anchor = GridBagConstraints.SOUTH;
	        gbc_textCedula.fill = GridBagConstraints.HORIZONTAL;
	        gbc_textCedula.insets = new Insets(0, 0, 0, 5);
	        gbc_textCedula.gridx = 0;
	        gbc_textCedula.gridy = 1;
	        panel.add(textCedula, gbc_textCedula);
	        textCedula.setColumns(10);

	        JButton btnOperaciones = new JButton("- Operaciones -");
	        btnOperaciones.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        			        		
	        		Double cedulaEst = Double.parseDouble(textCedula.getText());
	        		
	        		ObtencionCedulaEnviar(cedulaEst);
	        		
	        		
	        			
	        		
	        	}
	        });
	        btnOperaciones.setFont(new Font("Dialog", Font.PLAIN, 16));
	        btnOperaciones.setBorder(UIManager.getBorder("RootPane.frameBorder"));
	        btnOperaciones.setForeground(new Color(255, 255, 255));
	        btnOperaciones.setBackground(new Color(50, 101, 255));
	        GridBagConstraints gbc_btnOperaciones = new GridBagConstraints();
	        gbc_btnOperaciones.anchor = GridBagConstraints.SOUTHWEST;
	        gbc_btnOperaciones.insets = new Insets(0, 0, 0, 5);
	        gbc_btnOperaciones.gridx = 1;
	        gbc_btnOperaciones.gridy = 1;
	        panel.add(btnOperaciones, gbc_btnOperaciones);

	        JButton btnAsignarSeccion = new JButton("- Asignar -");
	        btnAsignarSeccion.setFont(new Font("Dialog", Font.PLAIN, 16));
	        btnAsignarSeccion.setBorder(UIManager.getBorder("RootPane.frameBorder"));
	        btnAsignarSeccion.setBackground(new Color(50, 101, 255));
	        btnAsignarSeccion.setForeground(new Color(255, 255, 255));
	        GridBagConstraints gbc_btnAsignarSeccion = new GridBagConstraints();
	        gbc_btnAsignarSeccion.anchor = GridBagConstraints.SOUTHEAST;
	        gbc_btnAsignarSeccion.insets = new Insets(0, 0, 0, 5);
	        gbc_btnAsignarSeccion.gridx = 2;
	        gbc_btnAsignarSeccion.gridy = 1;
	        panel.add(btnAsignarSeccion, gbc_btnAsignarSeccion);

	        comboSeccion = new JComboBox<>();
	        comboSeccion.setBackground(new Color(255, 255, 255));
	        comboSeccion.setBorder(new TitledBorder(null, "Secci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	        comboSeccion.setModel(new DefaultComboBoxModel<>(new String[] {"N/A", "A", "B", "C", "D", "E", "F", "G", "H", "I"}));
	        GridBagConstraints gbc_comboSeccion = new GridBagConstraints();
	        gbc_comboSeccion.fill = GridBagConstraints.HORIZONTAL;
	        gbc_comboSeccion.gridx = 3;
	        gbc_comboSeccion.gridy = 1;
	        panel.add(comboSeccion, gbc_comboSeccion);


	}


	   
	
	


	   private void InicioTabla() {
	    
	        tableIngresos.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		
	        		 tableDatosMouseClicked(e);
	        		
	        		
	        		
	        		
	        		
	        	}

				
	        });
	        
	        
	        
	        
	        tableIngresos.setForeground(new Color(61, 56, 70));


	        tableIngresos.setModel(new DefaultTableModel(new Object[][]{
	        	
	        	
	        	
	        },
	                new String[]{
	                        "P.Esc", "Id_ingresos", "Cedula", "Apellidos y Nombres", "Sexo", "Fech. Nac",  "Año Est", "Secc",  "Dirección", "Telefonos","Email", "Lugar Nac", "Condición Est", "Status", "Plantel Proced"
	                }));
	        tableIngresos.setRowMargin(4);
	        tableIngresos.setShowGrid(true);

	        tableIngresos.getTableHeader().setBackground(Color.decode("#3366FF"));
	        tableIngresos.getTableHeader().setForeground(Color.white);
	        tableIngresos.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
	        ;
	        

	        Utilitario u = new Utilitario();
	        String tipoFont = "Roboto-Bold";

	        try {
	            tableIngresos.setFont(u.tipoLetra(tipoFont, 12));
	        } catch (IOException | FontFormatException e) {
	            throw new RuntimeException(e);
	        }


	        tableIngresos.setBackground(new Color(255, 255, 255));

	        /* Para Alinear */

	        DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
	        alinear.setHorizontalAlignment(SwingConstants.CENTER);
	        tableIngresos.getColumnModel().getColumn(0).setCellRenderer(alinear);
	        tableIngresos.getColumnModel().getColumn(1).setCellRenderer(alinear);
	        tableIngresos.getColumnModel().getColumn(2).setCellRenderer(alinear);
	        tableIngresos.getColumnModel().getColumn(4).setCellRenderer(alinear);
	        tableIngresos.getColumnModel().getColumn(6).setCellRenderer(alinear);
	        tableIngresos.getColumnModel().getColumn(7).setCellRenderer(alinear);
	        tableIngresos.getColumnModel().getColumn(12).setCellRenderer(alinear);
	        tableIngresos.getColumnModel().getColumn(13).setCellRenderer(alinear);




	        JScrollPanel1.setBackground(Color.decode("#FFFFFF"));
	        JScrollPanel1.setViewportView(tableIngresos);
	        tableIngresos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	        
	        tableIngresos.setDefaultEditor(Object.class, null); // celdas no editable



	    }
	   
	   
	   private void tableDatosMouseClicked(MouseEvent e) {
			 if (e.getClickCount() == 2) {
  	            // primero, obtengo la fila seleccionada
  	            int fila1 = tableIngresos.getSelectedRow();
  	            String cedula = String.valueOf(tableIngresos.getValueAt(fila1, 2));
  	            //System.out.println("La cedula clicliada es: "+ cedula);
  	            
  	          Double cedulaEst = Double.parseDouble(cedula);
      		
      		ObtencionCedulaEnviar(cedulaEst);
      		
  	            
  	            
  	            
  		 }

			
		}
	   
	   
	   
	   
	   
	   private void ObtencionCedulaEnviar(Double cedulaEst) {
		   
		   DAOIngresos dao = new DAOIngresosImpl();
   		
   		
   		try {
				//Double comprobarCedula = dao.getIdCed(cedulaEst).getCedulaest();
   			List<Ingresos> comprobarCedula = dao.listarHistorial(cedulaEst);
   		
					
				if (comprobarCedula.isEmpty()) {
					JOptionPane.showMessageDialog(this,"ESTE ESTUDIANTE CON CÉDULA:  " + cedulaEst.intValue() + "  NO ESTA REGISTRADO", "ERROR..",JOptionPane.ERROR_MESSAGE);
					
					 int confirmado = JOptionPane.showConfirmDialog(this, "¿QUIERE REGISTRAR A ESTE ESTUDIANTE?", "SELECCIONE UNA OPCIÓN", JOptionPane.YES_NO_OPTION);
			            if (JOptionPane.NO_OPTION == confirmado) {
			            	textCedula.setText("");
							textCedula.requestFocusInWindow(); 
							return;
			            }else {
			            	JPanel panelComponente = new IngresosOperaciones(null,false).getPrincipal();
							principal.removeAll();
							principal.add(panelComponente,BorderLayout.CENTER);
							principal.revalidate();
							principal.repaint();
						}
					
					
					
					
					
				} else {
				
					JPanel panelComponente = new IngresoAsignarOperacion(cedulaEst).getPrincipal();
					principal.removeAll();
					principal.add(panelComponente,BorderLayout.CENTER);
					principal.revalidate();
					principal.repaint();
		                
					
				}
					
   		
   		} catch (SQLException e1) {
				
   			System.out.println(e1.getMessage());
			}
   		
		   
	   }
	   
	   


	   private void LoadIngresos() {
	        try {
	            DAOIngresos dao = new DAOIngresosImpl();

	            DefaultTableModel model = (DefaultTableModel) tableIngresos.getModel();
	            dao.listar().forEach((Ingresos ing) -> model.addRow(new Object[]{
	                    ing.getPeriodoescolar() ,
	                    ing.getId_ingreso(),
	                    ing.getCedulaestFormateada(),
	                    ing.getNombreCompleto(),
	                    ing.getSexoest(),
	                    ing.getFnest(),
	                    ing.getAnoest(),
	                    ing.getSecion(),
	                    ing.getDireccionest(),
	                    ing.getTelefonoest(),
	                    ing.getEmailest(),
	                    ing.getLugar_nac(),
	                    ing.getCondicionest(),
	                    ing.getStatus(),
	                    ing.getNombre_plantel()



	            }));


	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }




}
