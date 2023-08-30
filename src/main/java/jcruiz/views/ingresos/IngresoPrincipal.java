package jcruiz.views.ingresos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import jcruiz.DAOIngresosImpl;
import jcruiz.Utilitario;
import jcruiz.interfaces.DAOIngresos;
import jcruiz.models.Ingresos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

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
	 private Component horizontalStrut;
	 private JPanel principal;

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
	        resizeColumnWidth(tableIngresos);

	        JPanel botonera = new JPanel();
	        botonera.setBackground(new Color(255, 255, 255));
	        principal.add(botonera, BorderLayout.SOUTH);
	        GridBagLayout gbl_botonera = new GridBagLayout();
	        gbl_botonera.columnWidths = new int[]{100, 110, 92, 124, 0};
	        gbl_botonera.rowHeights = new int[]{0, 0};
	        gbl_botonera.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
	        
	        horizontalStrut = Box.createHorizontalStrut(20);
	        GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
	        gbc_horizontalStrut.fill = GridBagConstraints.HORIZONTAL;
	        gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
	        gbc_horizontalStrut.gridx = 2;
	        gbc_horizontalStrut.gridy = 0;
	        botonera.add(horizontalStrut, gbc_horizontalStrut);

	        JButton btnNuevoIngreso = new JButton("- Ingresar Nuevo -");
	        btnNuevoIngreso.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		JPanel panelComponente = new IngresosOperaciones().getPrincipal();
	                principal.setSize(960,300);
	                //principal.setLocation(0,0);
	                principal.removeAll();
	                principal.add(panelComponente,BorderLayout.CENTER);
	                principal.revalidate();
	                principal.repaint();

	        		
	        		
	        		
	        		
	        	}
	        });
	        btnNuevoIngreso.setBorder(UIManager.getBorder("RootPane.frameBorder"));
	        btnNuevoIngreso.setFont(new Font("Dialog", Font.PLAIN, 16));
	        btnNuevoIngreso.setForeground(new Color(255, 255, 255));
	        btnNuevoIngreso.setBackground(new Color(50, 101, 255));
	        btnNuevoIngreso.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	        GridBagConstraints gbc_btnNuevoIngreso = new GridBagConstraints();
	        gbc_btnNuevoIngreso.anchor = GridBagConstraints.SOUTHEAST;
	        gbc_btnNuevoIngreso.gridx = 3;
	        gbc_btnNuevoIngreso.gridy = 0;
	        botonera.add(btnNuevoIngreso, gbc_btnNuevoIngreso);

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

	        JButton btnBuscarCedula = new JButton("- Buscar -");
	        btnBuscarCedula.setFont(new Font("Dialog", Font.PLAIN, 16));
	        btnBuscarCedula.setBorder(UIManager.getBorder("RootPane.frameBorder"));
	        btnBuscarCedula.setForeground(new Color(255, 255, 255));
	        btnBuscarCedula.setBackground(new Color(50, 101, 255));
	        GridBagConstraints gbc_btnBuscarCedula = new GridBagConstraints();
	        gbc_btnBuscarCedula.anchor = GridBagConstraints.SOUTHWEST;
	        gbc_btnBuscarCedula.insets = new Insets(0, 0, 0, 5);
	        gbc_btnBuscarCedula.gridx = 1;
	        gbc_btnBuscarCedula.gridy = 1;
	        panel.add(btnBuscarCedula, gbc_btnBuscarCedula);

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


	   private void resizeColumnWidth(JTable table) {
	        //Se obtiene el modelo de la columna
	        TableColumnModel columnModel = table.getColumnModel();
	        //Se obtiene el total de las columnas
	        for (int column = 0; column < table.getColumnCount(); column++) {
	            //Establecemos un valor minimo para el ancho de la columna
	            int width = 60; //Min Width
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
//	            if (width > 960) {
//	                width = 960;
//	            }
	            //Se establece el ancho de la columna
	            columnModel.getColumn(column).setPreferredWidth(width);
	        }
	    }


	   private void InicioTabla() {


	        tableIngresos.setModel(new DefaultTableModel(new Object[][]{
	        },
	                new String[]{
	                        "P.Esc", "Id_ingresos", "Cedula", "Apellidos y Nombres", "Sexo", "Fech. Nac",  "Año Est", "Secc",  "Dirección", "Telefonos","Email", "Lugar Nac", "Condición Est", "Status", "Plantel Proced"
	                }));
	        tableIngresos.setRowMargin(1);
	        tableIngresos.setShowGrid(true);

	        tableIngresos.getTableHeader().setBackground(Color.decode("#3366FF"));
	        tableIngresos.getTableHeader().setForeground(Color.white);
	        tableIngresos.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
	        tableIngresos.setEnabled(false);

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
	        tableIngresos.getColumnModel().getColumn(4).setCellRenderer(alinear);
	        tableIngresos.getColumnModel().getColumn(6).setCellRenderer(alinear);
	        tableIngresos.getColumnModel().getColumn(7).setCellRenderer(alinear);



	        //JScrollPanel1.setBackground(UIManager.getDefaults().getColor("white"));

	        JScrollPanel1.setBackground(Color.decode("#FFFFFF"));


	        JScrollPanel1.setViewportView(tableIngresos);

	        tableIngresos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);



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
