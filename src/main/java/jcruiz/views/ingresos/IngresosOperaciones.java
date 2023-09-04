package jcruiz.views.ingresos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.github.lgooddatepicker.components.DatePicker;

import jcruiz.Utilitario;
import jcruiz.implementaciones.DAOEstudiantesImpl;
import jcruiz.implementaciones.DAOIngresosImpl;
import jcruiz.implementaciones.DAORepresentantesImpl;
import jcruiz.implementaciones.DAOViviendasImpl;
import jcruiz.interfaces.DAOEstudiantes;
import jcruiz.interfaces.DAOIngresos;
import jcruiz.interfaces.DAORepresentantes;
import jcruiz.interfaces.DAOViviendas;
import jcruiz.models.Estudiantes;
import jcruiz.models.Ingresos;
import jcruiz.models.Representantes;
import jcruiz.models.Viviendas;

public class IngresosOperaciones extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel botonera;
	private JButton btnIngreso;
	private JButton btnModificar;
	private JButton btnReiscripcion;
	private JButton btnEgreso;
	private JPanel principal;
	private JScrollPane scrollPane;
	private JPanel content;
	private JTextField textNombresEst;
	private JTextField textEdad;
	private JComboBox<Object> comboOrdenNac;
	private JButton btnBuscar;
	private DatePicker dpFechaNac;
	private JComboBox<Object> comboEstadoNac;
	private JTextField textLugarNac;
	private JComboBox<Object> comboEstadoCivil;
	private JComboBox<Object> comboMp;
	private JComboBox<Object> comboCondicionEst;
	private JComboBox<Object> comboAnoest;
	private JComboBox<Object> comboSeccion;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox<Object> comboTipoVia;
	private JTextField textDireccionEst;
	private JComboBox<Object> comboZonaUbicacion;
	private JComboBox<Object> comboTipoVivienda;
	private JComboBox<Object> comboUbicacionVivienda;
	private JComboBox<Object> comboCondicionVivienda;
	private JComboBox<Object> comboCondicionInfra;
	private JTextField textEmail;
	private JComboBox<Object> comboPlantelProc;
	private JTextField textObservaciones;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textCedularep;
	private JTextField textApellidosRep;
	private JTextField textNombresRep;
	private JComboBox<Object> comboSexoRep;
	private JComboBox<Object> comboParentesco;
	private JTextField textTelefonos;
	private JTextField textEmailRep;
	private JComboBox<Object> comboTrabaja;
	private JTextField textLugarTrabajo;
	private JComboBox<Object> comboSueldo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnSI;
	private JRadioButton rdbtnNO;
	private JPanel botonesDireccion;
	private JTextField textDireccionRep;
	private JLabel lblNewLabel_7;
	private JButton btnEliminar;
	private JPanel superior;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JPanel panel_Documentos;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private JCheckBox chckbxNewCheckBox_3;
	private JCheckBox chckbxNewCheckBox_4;
	private JLabel lblNewLabel_10;
	private JPanel panel;
	private JTextField textFicha;
	private DatePicker dpFechaIngreso;
	private JLabel lblNewLabel_11;
	private JTextField textApellidosEst;
	private JComboBox<Object> comboLateralidad;
	private JComboBox<Object> comboSexoEst;
	private JTextField textCedula;

	public JPanel getPrincipal() {
		return principal;
	}

	public IngresosOperaciones() {

		iniciarComponentes();
		
		Utilitario u = new Utilitario();
		
	//	String  prueba = Dashboard.periodoescolar;
		
		String  prueba = u.getPeriodoescolar();
		
		System.out.println("el periodo escolar es: "+ prueba);
		
				
		u.llenar_plantel(comboPlantelProc);
		u.llenar_estados(comboEstadoNac);

		
		
		btnIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					ingresar();

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}

		});

		dpFechaNac.getComponentDateTextField().addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				calcularEdad();

			}
		});
		
		
		
		rdbtnSI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSI.isSelected()) {

		            String DIRECCION = textDireccionEst.getText();

		            textDireccionRep.setText(DIRECCION);

		        }else {
		        	textDireccionRep.setText("");
		        }
			}
		});

		
		
		
		
		
		
		
		
		
		

	}

	/* OPERACIONES */

	private void ingresar() throws SQLException {

		/* VALIDACIONES */

		/*
		 * if (textCedula.getText().equals("")) {
		 * 
		 * JOptionPane.showMessageDialog(this,
		 * "DEBE INTRODUCIR EL NUMERO DE CEDULA DEL ESTUDIANTE", "ERROR..",
		 * JOptionPane.ERROR_MESSAGE); textCedula.requestFocusInWindow(); return; }
		 * 
		 * if (textApellidosEst.getText().equals("")) {
		 * 
		 * JOptionPane.showMessageDialog(this,
		 * "DEBE INTRODUCIR LOS APELLIDOS DEL ESTUDIANTE", "ERROR..",
		 * JOptionPane.ERROR_MESSAGE);
		 * 
		 * textApellidosEst.requestFocusInWindow(); return;
		 * 
		 * }
		 * 
		 * 
		 * if (textNombresEst.getText().equals("")) {
		 * 
		 * JOptionPane.showMessageDialog(this,
		 * "DEBE INTRODUCIR LOS NOMBRES DEL ESTUDIANTE", "ERROR..",
		 * JOptionPane.ERROR_MESSAGE);
		 * 
		 * textNombresEst.requestFocusInWindow(); return;
		 * 
		 * }
		 * 
		 * if (comboSexoEst.getSelectedItem().equals("N/A")) {
		 * 
		 * JOptionPane.showMessageDialog(this,
		 * "DEBE SELECCIONAR EL SEXO DEL ESTUDIANTE", "ERROR..",
		 * JOptionPane.ERROR_MESSAGE);
		 * 
		 * comboSexoEst.requestFocusInWindow(); return; }
		 * 
		 * if (comboLateralidad.getSelectedItem().equals("N/A")) {
		 * 
		 * JOptionPane.showMessageDialog(this,
		 * "DEBE SELECCIONAR LATERALIDAD DEL ESTUDIANTE", "ERROR..",
		 * JOptionPane.ERROR_MESSAGE);
		 * 
		 * comboLateralidad.requestFocusInWindow(); return; }
		 * 
		 * if (dpFechaNac.getText().equals("")) {
		 * 
		 * JOptionPane.showMessageDialog(this, "DEBE INTRODUCIR FECHA DE NACIMIENTO",
		 * "ERROR..", JOptionPane.ERROR_MESSAGE);
		 * 
		 * dpFechaNac.requestFocusInWindow(); return; }
		 * 
		 * if (comboEstadoNac.getSelectedItem().equals("N/A")) {
		 * 
		 * JOptionPane.showMessageDialog(this, "DEBE INTRODUCIR ESTADO DE NACIMIENTO",
		 * "ERROR..", JOptionPane.ERROR_MESSAGE);
		 * 
		 * comboEstadoNac.requestFocusInWindow(); return; }
		 * 
		 * if (textLugarNac.getText().equals("")) {
		 * 
		 * JOptionPane.showMessageDialog(this, "DEBE INTRODUCIR LUGAR DE NACIMIENTO",
		 * "ERROR..", JOptionPane.ERROR_MESSAGE);
		 * 
		 * textLugarNac.requestFocusInWindow(); return; }
		 * 
		 * if (comboMp.getSelectedItem().equals("N/A")) {
		 * 
		 * JOptionPane.showMessageDialog(this,
		 * "DEBE INTRODUCIR SI POSEE MATERIA PENDIENTE", "ERROR..",
		 * JOptionPane.ERROR_MESSAGE);
		 * 
		 * comboMp.requestFocusInWindow(); return; }
		 * 
		 * if (comboCondicionEst.getSelectedItem().equals("N/A")) {
		 * 
		 * JOptionPane.showMessageDialog(this,
		 * "DEBE INTRODUCIR LA CONDICIÓN DEL ESTUDIANTE", "ERROR..",
		 * JOptionPane.ERROR_MESSAGE);
		 * 
		 * comboCondicionEst.requestFocusInWindow(); return; }
		 * 
		 * if (comboAnoest.getSelectedItem().equals("N/A")) {
		 * 
		 * JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN AÑO ESCOLAR",
		 * "ERROR..", JOptionPane.ERROR_MESSAGE); comboAnoest.requestFocusInWindow();
		 * return;
		 * 
		 * }
		 * 
		 * if (comboPlantelProc.getSelectedItem().equals("N/A")) {
		 * 
		 * JOptionPane.showMessageDialog(this,
		 * "DEBE SELECCIONAR PLANTEL DE PROCEDENCIA", "ERROR..",
		 * JOptionPane.ERROR_MESSAGE); comboPlantelProc.requestFocusInWindow(); return;
		 * 
		 * }
		 */
		

		Estudiantes estudiante = new Estudiantes();

		Double cedulaEst = Double.parseDouble(textCedula.getText());  
		String apellidosEst = textApellidosEst.getText().toUpperCase();
		String nombresEst = textNombresEst.getText().toUpperCase();
		String sexoest = (String) comboSexoEst.getSelectedItem();
		String lateralidad = (String)comboLateralidad.getSelectedItem();
		String fechaNacimiento = dpFechaNac.getDateStringOrEmptyString();
		int ordenNac = Integer.parseInt((String) comboOrdenNac.getSelectedItem());
		String estadoNac = (String)comboEstadoNac.getSelectedItem();
		String lugarNac = textLugarNac.getText().toUpperCase();
		String estadoCivil = (String) comboEstadoCivil.getSelectedItem();
		String direccionest = textDireccionEst.getText().toUpperCase();
		String telefonosEst = textTelefonos.getText();
		String emailest = textEmail.getText();
		String nombrePlantel = (String) comboPlantelProc.getSelectedItem();
		
		estudiante.setCedulaest(cedulaEst);
		estudiante.setApellidosest(apellidosEst);
		estudiante.setNombresest(nombresEst);
		estudiante.setSexoest(sexoest);
		estudiante.setLateralidad(lateralidad);
		estudiante.setFnest(fechaNacimiento);
		estudiante.setOrden_nac(ordenNac);
		estudiante.setEstado_nac(estadoNac);
		estudiante.setLugar_nac(lugarNac);
		estudiante.setEstado_civil(estadoCivil);
		estudiante.setDireccionest(direccionest);
		estudiante.setTelefonoest(telefonosEst);
		estudiante.setEmailest(emailest);
		estudiante.setNombre_plantel(nombrePlantel);

		Representantes representante = new Representantes();

		int cedulaRep = Integer.parseInt(textCedularep.getText());
		String apellidosRep = textApellidosRep.getText().toUpperCase();
		String nombresRep = textNombresRep.getText().toUpperCase();
		String sexoRep = (String) comboSexoRep.getSelectedItem();
		String parentescoRep = (String) comboParentesco.getSelectedItem();
		String direccionRep = textDireccionRep.getText();
		String telefonosRep = textTelefonos.getText();
		String emailRep = textEmailRep.getText();
		String trabajaRep = (String) comboTrabaja.getSelectedItem();
		String lugarTrabajoRep = textLugarTrabajo.getText();
		String sueldoRep = (String) comboSueldo.getSelectedItem();
		
		representante.setCedularep(cedulaRep);
		representante.setApellidosrep(apellidosRep);
		representante.setNombresrep(nombresRep);
		representante.setSexorep(sexoRep);
		representante.setParentescorep(parentescoRep);
		representante.setDireccionrep(direccionRep);
		representante.setTelefonosrep(telefonosRep);
		representante.setEmailrep(emailRep);
		representante.setTrabaja(trabajaRep);
		representante.setLugartrabajo(lugarTrabajoRep);
		representante.setSueldo(sueldoRep);

		
		int cedularep = representante.getCedularep();
		
		Ingresos ingreso = new Ingresos();
		String CedulaF = estudiante.getCedulaestFormateada();
		
		
		String periodoescolar = (new Utilitario().getPeriodoescolar()).trim();
		String id_ingreso =  periodoescolar + "-" + CedulaF + "I";
		String condicionEst = (String) comboCondicionEst.getSelectedItem();
		String materiaPendiente = (String) comboMp.getSelectedItem();
		String annoEst = (String) comboAnoest.getSelectedItem();
		String seccionEst = (String) comboSeccion.getSelectedItem();
		String fechaIngreso = dpFechaIngreso.getDateStringOrEmptyString();
					
		String mesIngreso = (new Utilitario().obtenerMesIngreso(fechaIngreso));
		
		String fechaSistema = LocalDate.now().toString();
		String observacion = textObservaciones.getText().toUpperCase();
		//String inscriptor =;
		String ficha = textFicha.getText();
		
		
		ingreso.setId_ingreso(id_ingreso);
		ingreso.setPeriodoescolar(periodoescolar);
		ingreso.setCedulaest(cedulaEst);
		ingreso.setCondicionest(condicionEst);
		ingreso.setMateriapendiente(materiaPendiente);
		ingreso.setAnoest(annoEst);
		ingreso.setSecion(seccionEst);
		ingreso.setCedularep(cedularep);
		ingreso.setFecha_ingreso(fechaIngreso);
		ingreso.setMes_ingreso(mesIngreso);
		ingreso.setFechasistema(fechaSistema);
		ingreso.setStatus("I");
		ingreso.setObservacion(observacion);
		ingreso.setInscriptor("MALLUYA");
		ingreso.setFicha(ficha);
		ingreso.setNombre_plantel(nombrePlantel);

		Viviendas vivienda = new Viviendas();

		String tipoVia = (String) comboTipoVia.getSelectedItem();
		String zonaUbicacion = (String) comboZonaUbicacion.getSelectedItem();
		String tipoVivienda = (String) comboTipoVivienda.getSelectedItem();
		String ubicacionVivienda = (String) comboUbicacionVivienda.getSelectedItem();
		String condicionVivienda = (String) comboCondicionVivienda.getSelectedItem();
		String condInfraestructura = (String) comboCondicionInfra.getSelectedItem();
		
		vivienda.setId_ingreso(id_ingreso);
		vivienda.setTipovia(tipoVia);
		vivienda.setDireccionest(direccionest);
		vivienda.setZonaubicacion(zonaUbicacion);
		vivienda.setTipovivienda(tipoVivienda);
		vivienda.setUbicacionvivienda(ubicacionVivienda);
		vivienda.setCondicionvivienda(condicionVivienda);
		vivienda.setInfraestructura(condInfraestructura);

	
		
		DAOEstudiantes est = new DAOEstudiantesImpl();
		est.registrar(estudiante);

		DAORepresentantes rep = new DAORepresentantesImpl();
	 	rep.registrar(representante);

		DAOIngresos ing = new DAOIngresosImpl();
	    ing.registrar(ingreso);

		DAOViviendas viv = new DAOViviendasImpl();
	    viv.registrar(vivienda);

		JOptionPane.showMessageDialog(this, "EL ESTUDIANTE  FUE INGRESADO CORRECTAMENTE", "Registro..",
				JOptionPane.INFORMATION_MESSAGE);

	
		
		
	}

		
	
	
	
	private void calcularEdad() {

		String fechaAjuste = "2023-09-01";
		String fechaNacimiento = dpFechaNac.getDateStringOrEmptyString();

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);

		// LocalDate ahora = LocalDate.now();
		LocalDate ahora = LocalDate.parse(fechaAjuste, fmt);

		Period periodo = Period.between(fechaNac, ahora);

		/*
		 * System.out.printf("Tu edad es: %s años, %s meses y %s días",
		 * periodo.getYears(), periodo.getMonths(), periodo.getDays());
		 */

		String edad = periodo.getYears() + " años" + " y " + periodo.getMonths() + " Mese(s)";

		textEdad.setText(edad);

	}
	
	
	
	
	
	
	

	private void iniciarComponentes() {
		setBorder(null);
		setLayout(new BorderLayout(0, 0));

		principal = new JPanel();
		principal.setBorder(new EmptyBorder(0, 0, 0, 0));
		principal.setBackground(new Color(255, 255, 255));
		add(principal, BorderLayout.CENTER);
		principal.setLayout(new BorderLayout(0, 0));

		botonera = new JPanel();
		principal.add(botonera, BorderLayout.SOUTH);
		botonera.setLayout(new GridLayout(1, 0, 0, 0));

		btnIngreso = new JButton("Ingresar");
		btnIngreso.setIconTextGap(1);

		btnIngreso.setIcon(new ImageIcon(IngresosOperaciones.class.getResource("/Imagenes/46.png")));
		botonera.add(btnIngreso);

		btnModificar = new JButton("Modificar");

		btnModificar.setIconTextGap(1);
		btnModificar.setIcon(new ImageIcon(IngresosOperaciones.class.getResource("/Imagenes/44.png")));
		botonera.add(btnModificar);

		btnReiscripcion = new JButton("ReInscribir");
		btnReiscripcion.setIconTextGap(1);
		btnReiscripcion.setIcon(new ImageIcon(IngresosOperaciones.class.getResource("/Imagenes/48.png")));
		botonera.add(btnReiscripcion);

		btnEgreso = new JButton("Egresar");
		btnEgreso.setIconTextGap(1);
		btnEgreso.setIcon(new ImageIcon(IngresosOperaciones.class.getResource("/Imagenes/126.png")));
		botonera.add(btnEgreso);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIconTextGap(1);
		btnEliminar.setIcon(new ImageIcon(IngresosOperaciones.class.getResource("/Imagenes/116.png")));
		botonera.add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(10, 10));
		scrollPane.setBorder(null);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		principal.add(scrollPane, BorderLayout.CENTER);

		content = new JPanel();
		content.setBorder(new EmptyBorder(0, 0, 0, 0));
		content.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		content.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(content);
		GridBagLayout gbl_content = new GridBagLayout();
		gbl_content.columnWidths = new int[] { 150, 150, 91, 70, 100 };
		gbl_content.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				2 };
		gbl_content.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0 };
		gbl_content.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		content.setLayout(gbl_content);

		textCedula = new JTextField();
		textCedula.setFont(new Font("Dialog", Font.BOLD, 13));
		textCedula.setMinimumSize(new Dimension(10, 10));
		textCedula
				.setBorder(new TitledBorder(null, "C\u00E9dula:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textCedula.setColumns(10);
		GridBagConstraints gbc_textCedula = new GridBagConstraints();
		gbc_textCedula.anchor = GridBagConstraints.SOUTH;
		gbc_textCedula.insets = new Insets(0, 0, 5, 5);
		gbc_textCedula.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCedula.gridx = 0;
		gbc_textCedula.gridy = 0;
		content.add(textCedula, gbc_textCedula);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(IngresosOperaciones.class.getResource("/Imagenes/16.png")));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.WEST;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 0;
		content.add(btnBuscar, gbc_btnBuscar);

		textApellidosEst = new JTextField();
		textApellidosEst.setFont(new Font("Dialog", Font.BOLD, 13));
		textApellidosEst.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Apellidos:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textApellidosEst = new GridBagConstraints();
		gbc_textApellidosEst.anchor = GridBagConstraints.SOUTH;
		gbc_textApellidosEst.gridwidth = 2;
		gbc_textApellidosEst.insets = new Insets(0, 0, 5, 5);
		gbc_textApellidosEst.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellidosEst.gridx = 0;
		gbc_textApellidosEst.gridy = 1;
		content.add(textApellidosEst, gbc_textApellidosEst);
		textApellidosEst.setColumns(10);

		textNombresEst = new JTextField();
		textNombresEst.setFont(new Font("Dialog", Font.BOLD, 13));
		textNombresEst.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Nombres:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textNombresEst = new GridBagConstraints();
		gbc_textNombresEst.anchor = GridBagConstraints.SOUTH;
		gbc_textNombresEst.gridwidth = 2;
		gbc_textNombresEst.insets = new Insets(0, 0, 5, 5);
		gbc_textNombresEst.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombresEst.gridx = 2;
		gbc_textNombresEst.gridy = 1;
		content.add(textNombresEst, gbc_textNombresEst);
		textNombresEst.setColumns(10);

		comboSexoEst = new JComboBox<Object>();
		comboSexoEst.setBackground(new Color(255, 255, 255));
		comboSexoEst.setModel(new DefaultComboBoxModel<Object>(new String[] { "N/A", "F", "M" }));
		comboSexoEst.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Sexo:", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboSexoEst = new GridBagConstraints();
		gbc_comboSexoEst.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboSexoEst.anchor = GridBagConstraints.SOUTH;
		gbc_comboSexoEst.insets = new Insets(0, 0, 5, 0);
		gbc_comboSexoEst.gridx = 4;
		gbc_comboSexoEst.gridy = 1;
		content.add(comboSexoEst, gbc_comboSexoEst);

		comboLateralidad = new JComboBox<Object>();
		comboLateralidad.setBackground(new Color(255, 255, 255));
		comboLateralidad.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "N/A", "Derecho(a)", "Zurdo(a)", "Ambidiestro(a)" }));
		comboLateralidad.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Lateralidad:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboLateralidad = new GridBagConstraints();
		gbc_comboLateralidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboLateralidad.anchor = GridBagConstraints.SOUTH;
		gbc_comboLateralidad.insets = new Insets(0, 0, 5, 5);
		gbc_comboLateralidad.gridx = 0;
		gbc_comboLateralidad.gridy = 2;
		content.add(comboLateralidad, gbc_comboLateralidad);

		dpFechaNac = new DatePicker();
		dpFechaNac.getComponentDateTextField().setFont(new Font("Dialog", Font.BOLD, 13));

		dpFechaNac.getComponentDateTextField().setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"Fecha Nacimiento:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_dpFechaNac = new GridBagConstraints();
		gbc_dpFechaNac.insets = new Insets(0, 0, 5, 5);
		gbc_dpFechaNac.fill = GridBagConstraints.BOTH;
		gbc_dpFechaNac.gridx = 1;
		gbc_dpFechaNac.gridy = 2;
		content.add(dpFechaNac, gbc_dpFechaNac);

		textEdad = new JTextField();
		textEdad.setFont(new Font("Dialog", Font.BOLD, 14));

		textEdad.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Edad Calc.:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		textEdad.setColumns(10);
		GridBagConstraints gbc_textEdad = new GridBagConstraints();
		gbc_textEdad.gridwidth = 2;
		gbc_textEdad.anchor = GridBagConstraints.SOUTH;
		gbc_textEdad.insets = new Insets(0, 0, 5, 5);
		gbc_textEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEdad.gridx = 2;
		gbc_textEdad.gridy = 2;
		content.add(textEdad, gbc_textEdad);

		comboOrdenNac = new JComboBox<Object>();
		comboOrdenNac.setBackground(new Color(255, 255, 255));
		comboOrdenNac.setModel(new DefaultComboBoxModel<Object>(new String[] { "1", "2", "3", "4", "5", "6" }));
		comboOrdenNac.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Orden Nac",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboOrdenNac = new GridBagConstraints();
		gbc_comboOrdenNac.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboOrdenNac.anchor = GridBagConstraints.SOUTH;
		gbc_comboOrdenNac.insets = new Insets(0, 0, 5, 0);
		gbc_comboOrdenNac.gridx = 4;
		gbc_comboOrdenNac.gridy = 2;
		content.add(comboOrdenNac, gbc_comboOrdenNac);

		comboEstadoNac = new JComboBox<Object>();
		comboEstadoNac.setBackground(new Color(255, 255, 255));
		comboEstadoNac.setModel(new DefaultComboBoxModel<Object>(new String[] {"N/A"}));
		comboEstadoNac.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Estado Nac.:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboEstadoNac = new GridBagConstraints();
		gbc_comboEstadoNac.insets = new Insets(0, 0, 5, 5);
		gbc_comboEstadoNac.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboEstadoNac.gridx = 0;
		gbc_comboEstadoNac.gridy = 3;
		content.add(comboEstadoNac, gbc_comboEstadoNac);

		textLugarNac = new JTextField();
		textLugarNac.setFont(new Font("Dialog", Font.BOLD, 13));
		textLugarNac.setColumns(10);
		textLugarNac.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Lugar Nac.:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textLugarNac = new GridBagConstraints();
		gbc_textLugarNac.gridwidth = 2;
		gbc_textLugarNac.insets = new Insets(0, 0, 5, 5);
		gbc_textLugarNac.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLugarNac.gridx = 1;
		gbc_textLugarNac.gridy = 3;
		content.add(textLugarNac, gbc_textLugarNac);

		comboEstadoCivil = new JComboBox<Object>();
		comboEstadoCivil.setBackground(new Color(255, 255, 255));
		comboEstadoCivil
				.setModel(new DefaultComboBoxModel<Object>(new String[] { "Soltero(a)", "Casado(a)", "Concubinato" }));
		comboEstadoCivil.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Estado Civil:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboEstadoCivil = new GridBagConstraints();
		gbc_comboEstadoCivil.gridwidth = 2;
		gbc_comboEstadoCivil.insets = new Insets(0, 0, 5, 5);
		gbc_comboEstadoCivil.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboEstadoCivil.gridx = 3;
		gbc_comboEstadoCivil.gridy = 3;
		content.add(comboEstadoCivil, gbc_comboEstadoCivil);

		comboMp = new JComboBox<Object>();
		comboMp.setBackground(new Color(255, 255, 255));
		comboMp.setModel(new DefaultComboBoxModel<Object>(new String[] { "N/A", "NO", "SI" }));
		comboMp.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Materia Pendiente:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboMp = new GridBagConstraints();
		gbc_comboMp.insets = new Insets(0, 0, 5, 5);
		gbc_comboMp.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboMp.gridx = 0;
		gbc_comboMp.gridy = 4;
		content.add(comboMp, gbc_comboMp);

		comboCondicionEst = new JComboBox<Object>();
		comboCondicionEst.setBackground(new Color(255, 255, 255));
		comboCondicionEst.setModel(new DefaultComboBoxModel<Object>(new String[] { "N/A", "REGULAR", "NUEVO INGRESO",
				"REPITIENTE DE LA INST", "REPITIENTE DE OTRA INST", "REZAGDO" }));
		comboCondicionEst.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Condici\u00F3n Est.:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboCondicionEst = new GridBagConstraints();
		gbc_comboCondicionEst.insets = new Insets(0, 0, 5, 5);
		gbc_comboCondicionEst.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCondicionEst.gridx = 1;
		gbc_comboCondicionEst.gridy = 4;
		content.add(comboCondicionEst, gbc_comboCondicionEst);

		comboAnoest = new JComboBox<Object>();
		comboAnoest.setBackground(new Color(255, 255, 255));
		comboAnoest.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "N/A", "1ER AÑO", "2DO AÑO", "3R AÑO", "4TO AÑO CS", "5TO AÑO CS" }));
		comboAnoest.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "A\u00F1o Estudio:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboAnoest = new GridBagConstraints();
		gbc_comboAnoest.insets = new Insets(0, 0, 5, 5);
		gbc_comboAnoest.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboAnoest.gridx = 2;
		gbc_comboAnoest.gridy = 4;
		content.add(comboAnoest, gbc_comboAnoest);

		comboSeccion = new JComboBox<Object>();
		comboSeccion.setBackground(new Color(255, 255, 255));
		comboSeccion.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "NA", "A", "B", "C", "D", "E", "F", "G", "H", "I" }));
		comboSeccion.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Secci\u00F3n:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboSeccion = new GridBagConstraints();
		gbc_comboSeccion.insets = new Insets(0, 0, 5, 5);
		gbc_comboSeccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboSeccion.gridx = 3;
		gbc_comboSeccion.gridy = 4;
		content.add(comboSeccion, gbc_comboSeccion);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		textEmail.setColumns(10);
		textEmail.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Email:", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 0;
		gbc_textEmail.gridy = 5;
		content.add(textEmail, gbc_textEmail);
		
				comboPlantelProc = new JComboBox<Object>();
				comboPlantelProc.setModel(
						new DefaultComboBoxModel<Object>(new String[] {"N/A"}));
				comboPlantelProc.setBackground(new Color(255, 255, 255));
				comboPlantelProc.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Plantel de Procedencia",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
				GridBagConstraints gbc_comboPlantelProc = new GridBagConstraints();
				gbc_comboPlantelProc.gridwidth = 3;
				gbc_comboPlantelProc.insets = new Insets(0, 0, 5, 5);
				gbc_comboPlantelProc.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboPlantelProc.gridx = 1;
				gbc_comboPlantelProc.gridy = 5;
				content.add(comboPlantelProc, gbc_comboPlantelProc);

		lblNewLabel_4 = new JLabel("                                       ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		content.add(lblNewLabel_4, gbc_lblNewLabel_4);

		lblNewLabel_3 = new JLabel("Ubicación Domiciliaria del Estudiante:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(new Color(224, 27, 36));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 24));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.gridwidth = 3;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 7;
		content.add(lblNewLabel_3, gbc_lblNewLabel_3);

		comboTipoVia = new JComboBox<Object>();
		comboTipoVia.setModel(new DefaultComboBoxModel<Object>(new String[] { "N/A", "Autopista", "Avenida", "Calle",
				"Callejon", "Esquina", "Manzana", "Carretera", "Vereda" }));
		comboTipoVia.setBackground(new Color(255, 255, 255));
		comboTipoVia.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tipo V\u00EDa:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboTipoVia = new GridBagConstraints();
		gbc_comboTipoVia.insets = new Insets(0, 0, 5, 5);
		gbc_comboTipoVia.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTipoVia.gridx = 0;
		gbc_comboTipoVia.gridy = 8;
		content.add(comboTipoVia, gbc_comboTipoVia);

		textDireccionEst = new JTextField();
		textDireccionEst.setFont(new Font("Dialog", Font.BOLD, 13));
		textDireccionEst.setColumns(10);
		textDireccionEst.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"Direcci\u00F3n (URB/CALLE/SECTOR/VEREDA/N\u00B0CASA):", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(51, 51, 51)));
		GridBagConstraints gbc_textDireccionEst = new GridBagConstraints();
		gbc_textDireccionEst.gridwidth = 2;
		gbc_textDireccionEst.insets = new Insets(0, 0, 5, 5);
		gbc_textDireccionEst.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDireccionEst.gridx = 1;
		gbc_textDireccionEst.gridy = 8;
		content.add(textDireccionEst, gbc_textDireccionEst);

		comboZonaUbicacion = new JComboBox<Object>();
		comboZonaUbicacion.setModel(new DefaultComboBoxModel<Object>(new String[] { "N/A", "Urbana", "Rural" }));
		comboZonaUbicacion.setBackground(new Color(255, 255, 255));
		comboZonaUbicacion.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Zona Ubicaci\u00F3n:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboZonaUbicacion = new GridBagConstraints();
		gbc_comboZonaUbicacion.gridwidth = 2;
		gbc_comboZonaUbicacion.insets = new Insets(0, 0, 5, 5);
		gbc_comboZonaUbicacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboZonaUbicacion.gridx = 3;
		gbc_comboZonaUbicacion.gridy = 8;
		content.add(comboZonaUbicacion, gbc_comboZonaUbicacion);

		comboTipoVivienda = new JComboBox<Object>();
		comboTipoVivienda.setModel(new DefaultComboBoxModel<Object>(new String[] { "N/A", "Casa", "Apartamento",
				"Rancho", "Quinta", "Casa vecindad", "Improvisada", "Refugio" }));
		comboTipoVivienda.setBackground(new Color(255, 255, 255));
		comboTipoVivienda.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tipo Vivienda:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboTipoVivienda = new GridBagConstraints();
		gbc_comboTipoVivienda.insets = new Insets(0, 0, 5, 5);
		gbc_comboTipoVivienda.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTipoVivienda.gridx = 0;
		gbc_comboTipoVivienda.gridy = 9;
		content.add(comboTipoVivienda, gbc_comboTipoVivienda);

		comboCondicionInfra = new JComboBox<Object>();
		comboCondicionInfra.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "N/A", "Buena", "Deteriorada", "Deprorable", "Excelente", "Regular" }));
		comboCondicionInfra.setBackground(new Color(255, 255, 255));
		comboCondicionInfra.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"Cond. Infraestructura:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboCondicionInfra = new GridBagConstraints();
		gbc_comboCondicionInfra.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCondicionInfra.insets = new Insets(0, 0, 5, 5);
		gbc_comboCondicionInfra.gridx = 1;
		gbc_comboCondicionInfra.gridy = 9;
		content.add(comboCondicionInfra, gbc_comboCondicionInfra);

		comboUbicacionVivienda = new JComboBox<Object>();
		comboUbicacionVivienda.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "N/A", "Urbanización", "Barrio", "Caserio", "Zona Residencial" }));
		comboUbicacionVivienda.setBackground(new Color(255, 255, 255));
		comboUbicacionVivienda.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"Ubicaci\u00F3n Vivienda:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboUbicacionVivienda = new GridBagConstraints();
		gbc_comboUbicacionVivienda.gridwidth = 2;
		gbc_comboUbicacionVivienda.insets = new Insets(0, 0, 5, 5);
		gbc_comboUbicacionVivienda.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboUbicacionVivienda.gridx = 2;
		gbc_comboUbicacionVivienda.gridy = 9;
		content.add(comboUbicacionVivienda, gbc_comboUbicacionVivienda);

		comboCondicionVivienda = new JComboBox<Object>();
		comboCondicionVivienda.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "N/A", "Alquilada", "Propia Pagada", "Propia Pagandose",
						"Al Cuidado", "Arrimado", "Cedida", "De la Empresa", "Anexo", "Prestada", "Herencia" }));
		comboCondicionVivienda.setBackground(new Color(255, 255, 255));
		comboCondicionVivienda.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Cond. Vivienda:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_comboCondicionVivienda = new GridBagConstraints();
		gbc_comboCondicionVivienda.gridwidth = 2;
		gbc_comboCondicionVivienda.insets = new Insets(0, 0, 5, 5);
		gbc_comboCondicionVivienda.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCondicionVivienda.gridx = 0;
		gbc_comboCondicionVivienda.gridy = 10;
		content.add(comboCondicionVivienda, gbc_comboCondicionVivienda);

		textObservaciones = new JTextField();
		textObservaciones.setFont(new Font("Dialog", Font.BOLD, 13));
		textObservaciones.setColumns(10);
		textObservaciones.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Observaciones:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textObservaciones = new GridBagConstraints();
		gbc_textObservaciones.gridwidth = 4;
		gbc_textObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_textObservaciones.fill = GridBagConstraints.HORIZONTAL;
		gbc_textObservaciones.gridx = 0;
		gbc_textObservaciones.gridy = 11;
		content.add(textObservaciones, gbc_textObservaciones);

		lblNewLabel_5 = new JLabel("                                       ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 12;
		content.add(lblNewLabel_5, gbc_lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Datos del Representante:");
		lblNewLabel_6.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setForeground(new Color(224, 27, 36));
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 24));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_6.gridwidth = 3;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 13;
		content.add(lblNewLabel_6, gbc_lblNewLabel_6);

		textCedularep = new JTextField();
		textCedularep.setFont(new Font("Dialog", Font.BOLD, 13));
		textCedularep.setColumns(10);
		textCedularep
				.setBorder(new TitledBorder(null, "C\u00E9dula:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_textCedularep = new GridBagConstraints();
		gbc_textCedularep.insets = new Insets(0, 0, 5, 5);
		gbc_textCedularep.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCedularep.gridx = 0;
		gbc_textCedularep.gridy = 14;
		content.add(textCedularep, gbc_textCedularep);

		textApellidosRep = new JTextField();
		textApellidosRep.setFont(new Font("Dialog", Font.BOLD, 13));
		textApellidosRep.setColumns(10);
		textApellidosRep.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Apellidos:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textApellidosRep = new GridBagConstraints();
		gbc_textApellidosRep.gridwidth = 2;
		gbc_textApellidosRep.insets = new Insets(0, 0, 5, 5);
		gbc_textApellidosRep.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellidosRep.gridx = 0;
		gbc_textApellidosRep.gridy = 15;
		content.add(textApellidosRep, gbc_textApellidosRep);

		textNombresRep = new JTextField();
		textNombresRep.setFont(new Font("Dialog", Font.BOLD, 13));
		textNombresRep.setColumns(10);
		textNombresRep.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Nombres:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textNombresRep = new GridBagConstraints();
		gbc_textNombresRep.gridwidth = 2;
		gbc_textNombresRep.insets = new Insets(0, 0, 5, 5);
		gbc_textNombresRep.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombresRep.gridx = 2;
		gbc_textNombresRep.gridy = 15;
		content.add(textNombresRep, gbc_textNombresRep);

		comboSexoRep = new JComboBox<Object>();
		comboSexoRep.setModel(new DefaultComboBoxModel<Object>(new String[] {"N/A", "F", "M"}));
		comboSexoRep.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Sexo:", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(51, 51, 51)));
		comboSexoRep.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboSexoRep = new GridBagConstraints();
		gbc_comboSexoRep.insets = new Insets(0, 0, 5, 0);
		gbc_comboSexoRep.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboSexoRep.gridx = 4;
		gbc_comboSexoRep.gridy = 15;
		content.add(comboSexoRep, gbc_comboSexoRep);

		comboParentesco = new JComboBox<Object>();
		comboParentesco.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "N/A", "MADRE", "PADRE", "HERMANO(A)", "ABUELO(A)" }));
		comboParentesco.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Parentesco:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		comboParentesco.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboParentesco = new GridBagConstraints();
		gbc_comboParentesco.insets = new Insets(0, 0, 5, 5);
		gbc_comboParentesco.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboParentesco.gridx = 0;
		gbc_comboParentesco.gridy = 16;
		content.add(comboParentesco, gbc_comboParentesco);

		textTelefonos = new JTextField();
		textTelefonos.setFont(new Font("Dialog", Font.BOLD, 13));
		textTelefonos.setColumns(10);
		textTelefonos.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tel\u00E9fonos:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textTelefonos = new GridBagConstraints();
		gbc_textTelefonos.gridwidth = 2;
		gbc_textTelefonos.insets = new Insets(0, 0, 5, 5);
		gbc_textTelefonos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelefonos.gridx = 1;
		gbc_textTelefonos.gridy = 16;
		content.add(textTelefonos, gbc_textTelefonos);

		textEmailRep = new JTextField();
		textEmailRep.setFont(new Font("Dialog", Font.BOLD, 13));
		textEmailRep.setColumns(10);
		textEmailRep.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Email", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textEmailRep = new GridBagConstraints();
		gbc_textEmailRep.gridwidth = 2;
		gbc_textEmailRep.insets = new Insets(0, 0, 5, 0);
		gbc_textEmailRep.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmailRep.gridx = 3;
		gbc_textEmailRep.gridy = 16;
		content.add(textEmailRep, gbc_textEmailRep);

		comboTrabaja = new JComboBox<Object>();
		comboTrabaja.setModel(new DefaultComboBoxModel<Object>(new String[] { "N/A", "NO", "SI" }));
		comboTrabaja.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Trabaja:?",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		comboTrabaja.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboTrabaja = new GridBagConstraints();
		gbc_comboTrabaja.insets = new Insets(0, 0, 5, 5);
		gbc_comboTrabaja.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTrabaja.gridx = 0;
		gbc_comboTrabaja.gridy = 17;
		content.add(comboTrabaja, gbc_comboTrabaja);

		textLugarTrabajo = new JTextField();
		textLugarTrabajo.setFont(new Font("Dialog", Font.BOLD, 13));
		textLugarTrabajo.setColumns(10);
		textLugarTrabajo.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Lugar de Trabajo:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textLugarTrabajo = new GridBagConstraints();
		gbc_textLugarTrabajo.gridwidth = 2;
		gbc_textLugarTrabajo.insets = new Insets(0, 0, 5, 5);
		gbc_textLugarTrabajo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLugarTrabajo.gridx = 1;
		gbc_textLugarTrabajo.gridy = 17;
		content.add(textLugarTrabajo, gbc_textLugarTrabajo);

		comboSueldo = new JComboBox<Object>();
		comboSueldo.setModel(new DefaultComboBoxModel<Object>(new String[] { "N/A", "Minimo", "Mayor" }));
		comboSueldo.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Sueldo:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		comboSueldo.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboSueldo = new GridBagConstraints();
		gbc_comboSueldo.gridwidth = 2;
		gbc_comboSueldo.insets = new Insets(0, 0, 5, 5);
		gbc_comboSueldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboSueldo.gridx = 3;
		gbc_comboSueldo.gridy = 17;
		content.add(comboSueldo, gbc_comboSueldo);

		botonesDireccion = new JPanel();
		botonesDireccion.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Misma Direc. Est.?",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		botonesDireccion.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_botonesDireccion = new GridBagConstraints();
		gbc_botonesDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_botonesDireccion.fill = GridBagConstraints.BOTH;
		gbc_botonesDireccion.gridx = 0;
		gbc_botonesDireccion.gridy = 18;
		content.add(botonesDireccion, gbc_botonesDireccion);
		GridBagLayout gbl_botonesDireccion = new GridBagLayout();
		gbl_botonesDireccion.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_botonesDireccion.rowHeights = new int[] { 0, 0 };
		gbl_botonesDireccion.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_botonesDireccion.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		botonesDireccion.setLayout(gbl_botonesDireccion);

		rdbtnNO = new JRadioButton("NO");
		rdbtnNO.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_rdbtnNO = new GridBagConstraints();
		gbc_rdbtnNO.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnNO.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnNO.gridx = 0;
		gbc_rdbtnNO.gridy = 0;
		botonesDireccion.add(rdbtnNO, gbc_rdbtnNO);
		buttonGroup.add(rdbtnNO);

		lblNewLabel_7 = new JLabel("       ");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 0;
		botonesDireccion.add(lblNewLabel_7, gbc_lblNewLabel_7);

		rdbtnSI = new JRadioButton("SI");
				rdbtnSI.setBackground(new Color(255, 255, 255));
		rdbtnSI.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_rdbtnSI = new GridBagConstraints();
		gbc_rdbtnSI.anchor = GridBagConstraints.EAST;
		gbc_rdbtnSI.gridx = 2;
		gbc_rdbtnSI.gridy = 0;
		botonesDireccion.add(rdbtnSI, gbc_rdbtnSI);
		buttonGroup.add(rdbtnSI);

		textDireccionRep = new JTextField();
		textDireccionRep.setFont(new Font("Dialog", Font.BOLD, 13));
		textDireccionRep.setColumns(10);
		textDireccionRep.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),
				"Direcci\u00F3n (URB/CALLE/SECTOR/VEREDA/N\u00B0CASA):", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(51, 51, 51)));
		GridBagConstraints gbc_textDireccionRep = new GridBagConstraints();
		gbc_textDireccionRep.gridwidth = 3;
		gbc_textDireccionRep.insets = new Insets(0, 0, 5, 5);
		gbc_textDireccionRep.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDireccionRep.gridx = 1;
		gbc_textDireccionRep.gridy = 18;
		content.add(textDireccionRep, gbc_textDireccionRep);

		lblNewLabel_8 = new JLabel("                                       ");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 19;
		content.add(lblNewLabel_8, gbc_lblNewLabel_8);

		lblNewLabel_9 = new JLabel("\nDocumentos para Revisar (Opcional)");
		lblNewLabel_9.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9.setForeground(new Color(224, 27, 36));
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 24));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_9.gridwidth = 4;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 20;
		content.add(lblNewLabel_9, gbc_lblNewLabel_9);

		panel_Documentos = new JPanel();
		panel_Documentos.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_Documentos = new GridBagConstraints();
		gbc_panel_Documentos.gridwidth = 4;
		gbc_panel_Documentos.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Documentos.fill = GridBagConstraints.BOTH;
		gbc_panel_Documentos.gridx = 0;
		gbc_panel_Documentos.gridy = 21;
		content.add(panel_Documentos, gbc_panel_Documentos);
		panel_Documentos.setLayout(new GridLayout(1, 0, 0, 0));

		chckbxNewCheckBox = new JCheckBox("C.I. Est");
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		panel_Documentos.add(chckbxNewCheckBox);

		chckbxNewCheckBox_1 = new JCheckBox("Partida Nac. Est");
		chckbxNewCheckBox_1.setBackground(new Color(255, 255, 255));
		panel_Documentos.add(chckbxNewCheckBox_1);

		chckbxNewCheckBox_2 = new JCheckBox("Notas Cert.");
		chckbxNewCheckBox_2.setBackground(new Color(255, 255, 255));
		panel_Documentos.add(chckbxNewCheckBox_2);

		chckbxNewCheckBox_3 = new JCheckBox("C.I. Rep.");
		chckbxNewCheckBox_3.setBackground(new Color(255, 255, 255));
		panel_Documentos.add(chckbxNewCheckBox_3);

		chckbxNewCheckBox_4 = new JCheckBox("Permiso LOPNNA");
		chckbxNewCheckBox_4.setBackground(new Color(255, 255, 255));
		panel_Documentos.add(chckbxNewCheckBox_4);

		lblNewLabel_11 = new JLabel("   ");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 22;
		content.add(lblNewLabel_11, gbc_lblNewLabel_11);

		lblNewLabel_10 = new JLabel("   ");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 23;
		content.add(lblNewLabel_10, gbc_lblNewLabel_10);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 24;
		content.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		textFicha = new JTextField();
		textFicha.setColumns(8);
		textFicha.setBorder(
				new TitledBorder(new LineBorder(new Color(184, 207, 229)), "N\u00B0 FICHA DE INSCRIPCI\u00D3N:",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel.add(textFicha);

		dpFechaIngreso = new DatePicker();
		dpFechaIngreso.setBackground(new Color(255, 255, 255));
		dpFechaIngreso.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "FECHA DE INGRESO:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel.add(dpFechaIngreso);

		superior = new JPanel();
		principal.add(superior, BorderLayout.NORTH);
		superior.setLayout(new GridLayout(1, 0, 0, 0));

	}

	

}