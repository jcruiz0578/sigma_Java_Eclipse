package jcruiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import jcruiz.views.ingresos.IngresoPrincipal;
import jcruiz.views.matricula.MatriculaGeneral;



/**
 *
 */
public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;

	//private JLabel dateText;
	    private JLabel labelSIGMA;
	    String tipoFont;
	    private JButton btnPrincipal;
	    private JButton btnMatricula;
	    private JButton btnInscripcion;
	    private JButton btnConfiguracion;
	    private JLabel lblcopyright;
	    private JLabel lblcopyright1;
	    private JPanel contentPane;
	    private JPanel content;
	    private JPanel panel_bienvenido;
	    private JLabel textPeriodoEscolar;
	    
	    private String periodoescolar;







		/**
	 * Create the frame.
	 * @throws FontFormatException
	 * @throws IOException
	 */
	public Dashboard() throws IOException, FontFormatException {
			setPreferredSize(new Dimension(10, 10));
			setMinimumSize(new Dimension(10, 10));
			setBackground(new Color(255, 255, 255));
		setLocation(new Point(0, 0));
		setBounds(new Rectangle(0, 0, 0, 0));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1082, 563);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 877, 0};
		gbl_contentPane.rowHeights = new int[]{45, 64, 278, 70, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JPanel menu = new JPanel();
		menu.setBackground(new Color(0, 72, 125));
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.gridheight = 4;
		gbc_menu.insets = new Insets(0, 0, 0, 5);
		gbc_menu.fill = GridBagConstraints.BOTH;
		gbc_menu.gridx = 0;
		gbc_menu.gridy = 0;
		contentPane.add(menu, gbc_menu);
		menu.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel label_2 = new JLabel("");
		menu.add(label_2);

		labelSIGMA = new JLabel("SIGMA");
		labelSIGMA.setForeground(new Color(255, 255, 255));
		labelSIGMA.setHorizontalAlignment(SwingConstants.CENTER);
		labelSIGMA.setHorizontalTextPosition(SwingConstants.CENTER);
		labelSIGMA.setFont(new Font("Dialog", Font.BOLD, 24));
		labelSIGMA.setBackground(new Color(0, 72, 125));
		menu.add(labelSIGMA);

		JLabel label_6 = new JLabel("");
		menu.add(label_6);
						
								btnPrincipal = new JButton("Principal");
								btnPrincipal.setName(" ");
								btnPrincipal.setBorderPainted(false);
								btnPrincipal.setIconTextGap(7);
								btnPrincipal.setFocusable(false);
								btnPrincipal.setForeground(new Color(255, 255, 255));
								btnPrincipal.setFont(new Font("RobotoLight", Font.BOLD, 22));
								btnPrincipal.setBackground(new Color(50, 101, 255));
								btnPrincipal.setHorizontalAlignment(SwingConstants.LEFT);
								btnPrincipal.setFocusCycleRoot(true);
								btnPrincipal.setIcon(new ImageIcon(Dashboard.class.getResource("/Imagenes/home-outline.png")));
								menu.add(btnPrincipal);
				
						btnMatricula = new JButton("Matricula");
						btnMatricula.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								 
								try {
									ShowJPanel(new MatriculaGeneral());
								
								} catch (ClassNotFoundException | SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
						btnMatricula.setBorderPainted(false);
						btnMatricula.setIconTextGap(7);
						btnMatricula.setFocusable(false);
						btnMatricula.setIcon(new ImageIcon(Dashboard.class.getResource("/Imagenes/matricula.png")));
						btnMatricula.setHorizontalAlignment(SwingConstants.LEFT);
						btnMatricula.setForeground(Color.WHITE);
						btnMatricula.setFont(new Font("RobotoLight", Font.BOLD, 22));
						btnMatricula.setFocusCycleRoot(true);
						btnMatricula.setBackground(new Color(50, 101, 255));
						menu.add(btnMatricula);
		
				
						btnInscripcion = new JButton("Operaciones");
				btnInscripcion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						ShowJPanel(new IngresoPrincipal());
						
						
						
					}
				});
				
				
				
				btnInscripcion.setBorderPainted(false);
				btnInscripcion.setIconTextGap(7);
				btnInscripcion.setFocusable(false);
				btnInscripcion.setIcon(new ImageIcon(Dashboard.class.getResource("/Imagenes/wheel.png")));
				btnInscripcion.setHorizontalAlignment(SwingConstants.LEFT);
				btnInscripcion.setForeground(Color.WHITE);
				btnInscripcion.setFont(new Font("RobotoLight", Font.BOLD, 22));
				btnInscripcion.setFocusCycleRoot(true);
				btnInscripcion.setBackground(new Color(50, 101, 255));
				menu.add(btnInscripcion);

		JLabel label_7 = new JLabel("");
		menu.add(label_7);
		
				btnConfiguracion = new JButton("Configuración");
				
						btnConfiguracion.setBorderPainted(false);
						btnConfiguracion.setIconTextGap(1);
						btnConfiguracion.setFocusable(false);
						btnConfiguracion.setIcon(new ImageIcon(Dashboard.class.getResource("/Imagenes/usuario.png")));
						btnConfiguracion.setHorizontalAlignment(SwingConstants.LEFT);
						btnConfiguracion.setForeground(Color.WHITE);
						btnConfiguracion.setFont(new Font("RobotoLight", Font.BOLD, 22));
						btnConfiguracion.setFocusCycleRoot(true);
						btnConfiguracion.setBackground(new Color(50, 101, 255));
						menu.add(btnConfiguracion);

		JLabel label_8 = new JLabel("");
		menu.add(label_8);
		
		panel_bienvenido = new JPanel();
		panel_bienvenido.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_bienvenido = new GridBagConstraints();
		gbc_panel_bienvenido.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_bienvenido.anchor = GridBagConstraints.SOUTH;
		gbc_panel_bienvenido.insets = new Insets(0, 0, 5, 0);
		gbc_panel_bienvenido.gridx = 1;
		gbc_panel_bienvenido.gridy = 0;
		contentPane.add(panel_bienvenido, gbc_panel_bienvenido);
		panel_bienvenido.setLayout(new GridLayout(0, 1, 0, 0));
		
		textPeriodoEscolar = new JLabel("");
		textPeriodoEscolar.setBorder(new EmptyBorder(0, 0, 0, 5));
		textPeriodoEscolar.setBackground(new Color(255, 255, 255));
		textPeriodoEscolar.setHorizontalAlignment(SwingConstants.RIGHT);
		textPeriodoEscolar.setForeground(new Color(224, 27, 36));
		textPeriodoEscolar.setFont(new Font("Dialog", Font.BOLD, 22));
		panel_bienvenido.add(textPeriodoEscolar);

		JPanel header = new JPanel();
		header.setMinimumSize(new Dimension(10, 80));
		header.setPreferredSize(new Dimension(10, 80));
		header.setBackground(new Color(50, 101, 255));
		GridBagConstraints gbc_header = new GridBagConstraints();
		gbc_header.gridwidth = 2;
		gbc_header.insets = new Insets(0, 0, 5, 0);
		gbc_header.fill = GridBagConstraints.BOTH;
		gbc_header.gridx = 0;
		gbc_header.gridy = 1;
		contentPane.add(header, gbc_header);

		content = new JPanel();
		content.setAutoscrolls(true);
		content.setBorder(new EmptyBorder(0, 0, 0, 0));
		content.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_content = new GridBagConstraints();
		gbc_content.insets = new Insets(0, 0, 5, 0);
		gbc_content.fill = GridBagConstraints.BOTH;
		gbc_content.gridx = 1;
		gbc_content.gridy = 2;
		contentPane.add(content, gbc_content);
		content.setLayout(new BorderLayout(0, 0));

		JPanel footer = new JPanel();
		footer.setPreferredSize(new Dimension(10, 80));
		footer.setBackground(new Color(50, 101, 255));
		GridBagConstraints gbc_footer = new GridBagConstraints();
		gbc_footer.gridwidth = 2;
		gbc_footer.fill = GridBagConstraints.BOTH;
		gbc_footer.gridx = 0;
		gbc_footer.gridy = 3;
		contentPane.add(footer, gbc_footer);
		GridBagLayout gbl_footer = new GridBagLayout();
		gbl_footer.columnWidths = new int[]{240, 672, 0};
		gbl_footer.rowHeights = new int[]{17, 17, 0};
		gbl_footer.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_footer.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		footer.setLayout(gbl_footer);

		lblcopyright = new JLabel("Copyright© 2023: Todos los Derechos Reservados. SISTEMA INTEGRAL DE GESTIÓN MATRICULAR AVANZADO");
		lblcopyright.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblcopyright = new GridBagConstraints();
		gbc_lblcopyright.anchor = GridBagConstraints.NORTH;
		gbc_lblcopyright.insets = new Insets(0, 0, 5, 0);
		gbc_lblcopyright.gridx = 1;
		gbc_lblcopyright.gridy = 0;
		footer.add(lblcopyright, gbc_lblcopyright);

		lblcopyright1 = new JLabel("Realizado por: ING. JUAN CARLOS RUIZ HERNANDEZ");
		lblcopyright1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblcopyright1 = new GridBagConstraints();
		gbc_lblcopyright1.anchor = GridBagConstraints.NORTH;
		gbc_lblcopyright1.gridx = 1;
		gbc_lblcopyright1.gridy = 1;
		footer.add(lblcopyright1, gbc_lblcopyright1);




		IniMouseCursor();
		IniBottonHover();
		establecerFuentes();
		InicioShow();




	}


	public   void ShowJPanel(JPanel p){
	       p.setSize(400, 300);
	        p.setLocation(0,0);

	        content.removeAll();
	       content.add(p,BorderLayout.CENTER);

	        content.revalidate();
	        content.repaint();
	    }



	 private void InicioShow(){
		 
		 periodoescolar = "2022-2023";
		 Utilitario u = new Utilitario();
		 u.setPeriodoescolar(periodoescolar);;
		 
		 String xperiodoescolarTexto = "PERIODO ESCOLAR : " + periodoescolar;
		 textPeriodoEscolar.setText(xperiodoescolarTexto);
		 
		 
	       IngresoPrincipal ingresoPrincipal = new IngresoPrincipal();
	       ingresoPrincipal.setMinimumSize(new Dimension(10, 10));
	       ingresoPrincipal.getPrincipal().setMinimumSize(new Dimension(10, 10));
	       ingresoPrincipal.setPreferredSize(new Dimension(10, 10));
	       ingresoPrincipal.getPrincipal().setPreferredSize(new Dimension(10, 10));
	       ShowJPanel(ingresoPrincipal);
		 
		/* IngresosOperaciones ingresosOperaciones = new IngresosOperaciones();
		 ingresosOperaciones.setMinimumSize(new Dimension(10, 10));
	       ingresosOperaciones.setPreferredSize(new Dimension(10, 10));
	       ingresosOperaciones.getPrincipal().setPreferredSize(new Dimension(10, 10));
	       ShowJPanel(ingresosOperaciones);*/
	    }





private void establecerFuentes() throws IOException, FontFormatException {


	 Utilitario u = new Utilitario();
     tipoFont = "BRUSHSCI";
     labelSIGMA.setFont(u.tipoLetra(tipoFont,48));
     labelSIGMA.setForeground(Color.white);
     
     tipoFont = "segoeuisl";
     
     textPeriodoEscolar.setFont(u.tipoLetra(tipoFont,28));
     

     tipoFont = "Roboto-Bold";

     btnPrincipal.setFont(u.tipoLetra(tipoFont,22));
     btnMatricula.setFont(u.tipoLetra(tipoFont,22));
     btnInscripcion.setFont(u.tipoLetra(tipoFont,22));
     btnConfiguracion.setFont(u.tipoLetra(tipoFont,22));

   lblcopyright.setFont(u.tipoLetra(tipoFont,13));
   lblcopyright1.setFont(u.tipoLetra(tipoFont,13));
   lblcopyright.setForeground(Color.white);
   lblcopyright1.setForeground(Color.white);
}





private void IniMouseCursor() {
    for (JButton jButton : Arrays.asList(btnPrincipal, btnInscripcion, btnMatricula, btnConfiguracion)) {
        jButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

}


private void IniBottonHover() {
    for (final JButton jButton : Arrays.asList(btnPrincipal, btnInscripcion, btnMatricula, btnConfiguracion)) {


    	jButton.addMouseListener(new MouseAdapter() {

 		  @Override
		public void mouseEntered(MouseEvent e) { super.mouseEntered(e);
 		 jButton.setBackground(Color.decode("#07A2EF"));


  		  }

  		  @Override
		public void mouseExited(MouseEvent e) { super.mouseExited(e);

  		jButton.setBackground(Color.decode("#3366FF"));

  		  } }); }

  		  }





















}
