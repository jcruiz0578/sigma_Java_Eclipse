package jcruiz.views.ingresos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import jcruiz.Utilitario;
import jcruiz.implementaciones.DAOIngresosImpl;
import jcruiz.interfaces.DAOIngresos;
import jcruiz.models.Ingresos;

public class IngresoAsignarOperacion extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnProsecucion;
	private JButton btnModificarCI;
	private JButton btnConstancia;
	private JPanel principal;

	private JPanel superior;
	private JPanel botonera;
	private JScrollPane JScrollPanel1;

	JTable tableIngresos = new JTable();

	private JTextField textEstudiante;
	private JTextField textCedula;
	private JButton btnRepresentante;
	private JButton btnEgreso;

	private Boolean inscripcion = true;

	public JPanel getPrincipal() {
		return principal;
	}

	public IngresoAsignarOperacion(Double cedulaEst) {
		iniciarComponentes();

		InicioTabla();
		LoadIngresos(cedulaEst);
		new Utilitario().resizeColumnWidth(tableIngresos);
		comprobarPeriodoescolar(cedulaEst);

	}

	void comprobarPeriodoescolar(Double cedulaEst) {
		Utilitario u = new Utilitario();
		DAOIngresos dao = new DAOIngresosImpl();

		String periodoEscolarActual = u.getPeriodoescolar();

		try {

			Ingresos ingresos = dao.getComprobacionPeriodoescolar(cedulaEst, periodoEscolarActual);

			// si el resultado no arroja elementos vacios
			if (!(ingresos.getPeriodoescolar().isEmpty())) {
				JOptionPane.showMessageDialog(this, "EL ESTUDIANTE PERTENECE AL PERIODO ESCOLAR ACTUAL",
						"PROSECUCIÓN..", JOptionPane.INFORMATION_MESSAGE);

				btnProsecucion.setText("Modificar");
				btnProsecucion.setIcon(new ImageIcon(IngresoAsignarOperacion.class.getResource("/Imagenes/modif.png")));

				inscripcion = false;

				// System.out.println("Se hara es Modificar " +inscripcion);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void InicioTabla() {
		tableIngresos.setForeground(new Color(61, 56, 70));

		tableIngresos.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "P.Esc", "Id_ingresos", "Cedula", "Apellidos y Nombres", "Sexo", "Fech. Nac", "Año Est",
						"Secc", "Dirección", "Telefonos", "Email", "Lugar Nac", "Condición Est", "Status",
						"Plantel Proced" }));
		tableIngresos.setRowMargin(4);
		tableIngresos.setShowGrid(true);

		tableIngresos.getTableHeader().setBackground(Color.decode("#3366FF"));
		tableIngresos.getTableHeader().setForeground(Color.white);
		tableIngresos.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
		// tableIngresos.setEnabled(false);

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

	}

	private void LoadIngresos(Double cedulaEst) {

		try {
			DAOIngresos dao = new DAOIngresosImpl();

			DefaultTableModel model = (DefaultTableModel) tableIngresos.getModel();
			dao.listarHistorial(cedulaEst)
					.forEach((Ingresos ing) -> model.addRow(
							new Object[] { ing.getPeriodoescolar(), ing.getId_ingreso(), ing.getCedulaestFormateada(),
									ing.getNombreCompleto(), ing.getSexoest(), ing.getFnest(), ing.getAnoest(),
									ing.getSecion(), ing.getDireccionest(), ing.getTelefonoest(), ing.getEmailest(),
									ing.getLugar_nac(), ing.getCondicionest(), ing.getStatus(), ing.getNombre_plantel(),

							}));

			textCedula.setText(dao.getIdCed(cedulaEst).getCedulaestFormateada());
			textEstudiante.setText(dao.getIdCed(cedulaEst).getNombreCompleto());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void envioDeInformacion(Ingresos ingresos, Boolean inscripcion) {
		JPanel panelComponente = new IngresosOperaciones(ingresos, inscripcion).getPrincipal();
		// principal.setSize(960,300);
		// principal.setLocation(0,0);
		principal.removeAll();
		principal.add(panelComponente, BorderLayout.CENTER);
		principal.revalidate();
		principal.repaint();

	}

	private void iniciarComponentes() {

		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));

		principal = new JPanel();
		principal.setBackground(new Color(255, 255, 255));
		add(principal, BorderLayout.CENTER);
		principal.setLayout(new BorderLayout(0, 0));

		superior = new JPanel();
		superior.setBackground(new Color(255, 255, 255));
		principal.add(superior, BorderLayout.NORTH);
		GridBagLayout gbl_superior = new GridBagLayout();
		gbl_superior.columnWidths = new int[] { 116, 247, 0 };
		gbl_superior.rowHeights = new int[] { 36, 0 };
		gbl_superior.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_superior.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		superior.setLayout(gbl_superior);

		textCedula = new JTextField("cedula");
		textCedula.setEditable(false);
		textCedula.setBackground(new Color(255, 255, 255));
		textCedula
				.setBorder(new TitledBorder(null, "C\u00E9dula: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		textCedula.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textlCedula = new GridBagConstraints();
		gbc_textlCedula.fill = GridBagConstraints.BOTH;
		gbc_textlCedula.insets = new Insets(0, 0, 0, 5);
		gbc_textlCedula.gridx = 0;
		gbc_textlCedula.gridy = 0;
		superior.add(textCedula, gbc_textlCedula);

		textEstudiante = new JTextField("nombre");
		textEstudiante.setEditable(false);
		textEstudiante.setBackground(new Color(255, 255, 255));
		textEstudiante
				.setBorder(new TitledBorder(null, "Estudiante: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textEstudiante.setFont(new Font("Dialog", Font.BOLD, 22));
		textEstudiante.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_textEstudiante = new GridBagConstraints();
		gbc_textEstudiante.fill = GridBagConstraints.BOTH;
		gbc_textEstudiante.gridx = 1;
		gbc_textEstudiante.gridy = 0;
		superior.add(textEstudiante, gbc_textEstudiante);

		JScrollPanel1 = new JScrollPane();
		JScrollPanel1.setBackground(new Color(255, 255, 255));
		principal.add(JScrollPanel1, BorderLayout.CENTER);

		botonera = new JPanel();
		botonera.setBackground(new Color(255, 255, 255));
		botonera.setBorder(new EmptyBorder(0, 0, 30, 0));
		principal.add(botonera, BorderLayout.SOUTH);
		botonera.setLayout(new GridLayout(1, 0, 0, 0));

		btnProsecucion = new JButton("Prosecución");
		btnProsecucion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProsecucion.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnProsecucion.setToolTipText("");
		btnProsecucion.setVerticalAlignment(SwingConstants.TOP);
		btnProsecucion.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnProsecucion.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Ingresos ingresos;
				DAOIngresos dao = new DAOIngresosImpl();
				Double cedula = Double.parseDouble(textCedula.getText());

				try {
					ingresos = dao.getIdCed(cedula);

					envioDeInformacion(ingresos, inscripcion);

				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}

			}

		});

		btnProsecucion.setIcon(new ImageIcon(IngresoAsignarOperacion.class.getResource("/Imagenes/71.png")));
		botonera.add(btnProsecucion);

		btnModificarCI = new JButton("Modificar C.I");
		btnModificarCI.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnModificarCI.setVerticalAlignment(SwingConstants.TOP);
		btnModificarCI.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModificarCI.setIcon(new ImageIcon(IngresoAsignarOperacion.class.getResource("/Imagenes/contact.png")));
		botonera.add(btnModificarCI);

		btnRepresentante = new JButton("Representante");
		btnRepresentante.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRepresentante.setVerticalAlignment(SwingConstants.TOP);
		btnRepresentante.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRepresentante.setIconTextGap(1);
		btnRepresentante.setIcon(new ImageIcon(IngresoAsignarOperacion.class.getResource("/Imagenes/54.png")));
		botonera.add(btnRepresentante);

		btnEgreso = new JButton("Egreso");
		btnEgreso.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEgreso.setVerticalAlignment(SwingConstants.TOP);
		btnEgreso.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEgreso.setIcon(new ImageIcon(IngresoAsignarOperacion.class.getResource("/Imagenes/126.png")));
		botonera.add(btnEgreso);

		btnConstancia = new JButton("Constancia");
		btnConstancia.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConstancia.setVerticalAlignment(SwingConstants.TOP);
		btnConstancia.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConstancia.setIcon(new ImageIcon(IngresoAsignarOperacion.class.getResource("/Imagenes/8.png")));
		botonera.add(btnConstancia);

	}

}
