package jcruiz.views.ingresos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class IngresoAsignarOperacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textcedulaEst;
	private JButton btnProsecucion;
	private JButton btnModificarCI;
	private JButton btnConstancia;
	private JPanel principal;
	
	
	private JPanel superior;
	private JPanel botonera;
	private JScrollPane scrollPane;

	public JPanel getPrincipal() {
		return principal;
	}

	
	
	
	/**
	 * Create the panel.
	 */
	public IngresoAsignarOperacion() {
		setLayout(new BorderLayout(0, 0));
		
		principal = new JPanel();
		principal.setBackground(new Color(255, 255, 255));
		add(principal, BorderLayout.CENTER);
		principal.setLayout(new BorderLayout(0, 0));
		
		superior = new JPanel();
		superior.setBackground(new Color(255, 255, 255));
		principal.add(superior, BorderLayout.NORTH);
		GridBagLayout gbl_superior = new GridBagLayout();
		gbl_superior.columnWidths = new int[]{247, 247, 0};
		gbl_superior.rowHeights = new int[]{40, 0};
		gbl_superior.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_superior.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		superior.setLayout(gbl_superior);
		
		textcedulaEst = new JTextField();
		textcedulaEst.setFont(new Font("Dialog", Font.BOLD, 14));
		textcedulaEst.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "C\u00E9dula", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		textcedulaEst.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_textcedulaEst = new GridBagConstraints();
		gbc_textcedulaEst.fill = GridBagConstraints.BOTH;
		gbc_textcedulaEst.insets = new Insets(0, 0, 0, 5);
		gbc_textcedulaEst.gridx = 0;
		gbc_textcedulaEst.gridy = 0;
		superior.add(textcedulaEst, gbc_textcedulaEst);
		textcedulaEst.setColumns(3);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.setIcon(new ImageIcon(IngresoAsignarOperacion.class.getResource("/Imagenes/16.png")));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		superior.add(btnNewButton, gbc_btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		principal.add(scrollPane, BorderLayout.CENTER);
		
		botonera = new JPanel();
		botonera.setBorder(new EmptyBorder(0, 0, 30, 0));
		principal.add(botonera, BorderLayout.SOUTH);
		botonera.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnProsecucion = new JButton("Prosecución");
		btnProsecucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JPanel panelComponente = new IngresosOperaciones().getPrincipal();
	               // principal.setSize(960,300);
	                //principal.setLocation(0,0);
	                principal.removeAll();
	                principal.add(panelComponente,BorderLayout.CENTER);
	                principal.revalidate();
	                principal.repaint();
				
				
				
			}
		});
		btnProsecucion.setIcon(new ImageIcon(IngresoAsignarOperacion.class.getResource("/Imagenes/71.png")));
		botonera.add(btnProsecucion);
		
		btnModificarCI = new JButton("Modificar C.I");
		btnModificarCI.setIcon(new ImageIcon(IngresoAsignarOperacion.class.getResource("/Imagenes/44.png")));
		botonera.add(btnModificarCI);
		
		btnConstancia = new JButton("Constancia");
		btnConstancia.setIcon(new ImageIcon(IngresoAsignarOperacion.class.getResource("/Imagenes/8.png")));
		botonera.add(btnConstancia);

	}

}
