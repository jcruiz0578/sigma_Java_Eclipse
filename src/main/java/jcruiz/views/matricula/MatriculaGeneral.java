package jcruiz.views.matricula;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import jcruiz.db.DbConnection;

public class MatriculaGeneral extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtHembras;
	private JTextField txtVarones;
	private JTextField txtAosexo;
	private JTextField txtTotal;
	private JTextField txterAo;
	private JTextField txtdoAo;
	private JTextField txterAo_1;
	private JTextField txttoAo;
	private JTextField txttoAo_1;
	private JTextField txtTotales;
	private JLabel textH1;
	private JLabel textH2;
	private JLabel textH3;
	private JLabel textH4;
	private JLabel textH5;
	private JLabel textHTotal;
	private JLabel textV1;
	private JLabel textV2;
	private JLabel textV3;
	private JLabel textV4;
	private JLabel textV5;
	private JLabel textVTotal;
	private JLabel textTOTAL1;
	private JLabel textTOTAL2;
	private JLabel textTOTAL3;
	private JLabel textTOTAL4;
	private JLabel textTOTAL5;
	private JLabel textTOTALGENERAL;
	private JLabel lblNewLabel;
	Statement stmt = null;
	ResultSet res = null;
	
	 int totalH;
	 int totalV;
	
	
	int colum;
	int row;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public MatriculaGeneral() throws ClassNotFoundException, SQLException {

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		setLayout(new BorderLayout(0, 0));

		JPanel principal = new JPanel();
		add(principal, BorderLayout.CENTER);
		principal.setLayout(new BorderLayout(0, 0));

		JPanel content = new JPanel();
		content.setBackground(new Color(255, 255, 255));
		principal.add(content, BorderLayout.CENTER);
		GridBagLayout gbl_content = new GridBagLayout();
		gbl_content.columnWidths = new int[] { 20, 95, 90, 90, 80, 60, 6 };
		gbl_content.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_content.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_content.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		content.setLayout(gbl_content);

		lblNewLabel = new JLabel("Matricula Total General");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		content.add(lblNewLabel, gbc_lblNewLabel);

		txtAosexo = new JTextField();
		txtAosexo.setBorder(null);
		txtAosexo.setFont(new Font("Dialog", Font.BOLD, 16));
		txtAosexo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAosexo.setText("Año/Sexo");
		GridBagConstraints gbc_txtAosexo = new GridBagConstraints();
		gbc_txtAosexo.insets = new Insets(0, 0, 5, 5);
		gbc_txtAosexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAosexo.gridx = 1;
		gbc_txtAosexo.gridy = 1;
		content.add(txtAosexo, gbc_txtAosexo);
		txtAosexo.setColumns(10);

		txtHembras = new JTextField();
		txtHembras.setMaximumSize(new Dimension(100, 2147483647));
		txtHembras.setBorder(null);
		txtHembras.setFont(new Font("Dialog", Font.BOLD, 16));
		txtHembras.setHorizontalAlignment(SwingConstants.CENTER);
		txtHembras.setText("HEMBRAS");
		GridBagConstraints gbc_txtHembras = new GridBagConstraints();
		gbc_txtHembras.insets = new Insets(0, 0, 5, 5);
		gbc_txtHembras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHembras.gridx = 2;
		gbc_txtHembras.gridy = 1;
		content.add(txtHembras, gbc_txtHembras);
		txtHembras.setColumns(10);

		txtVarones = new JTextField();
		txtVarones.setMaximumSize(new Dimension(100, 2147483647));
		txtVarones.setBorder(null);
		txtVarones.setFont(new Font("Dialog", Font.BOLD, 16));
		txtVarones.setHorizontalAlignment(SwingConstants.CENTER);
		txtVarones.setText("VARONES");
		GridBagConstraints gbc_txtVarones = new GridBagConstraints();
		gbc_txtVarones.insets = new Insets(0, 0, 5, 5);
		gbc_txtVarones.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVarones.gridx = 3;
		gbc_txtVarones.gridy = 1;
		content.add(txtVarones, gbc_txtVarones);
		txtVarones.setColumns(10);

		txtTotal = new JTextField();
		txtTotal.setMaximumSize(new Dimension(100, 2147483647));
		txtTotal.setBorder(null);
		txtTotal.setFont(new Font("Dialog", Font.BOLD, 16));
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setText("TOTAL");
		GridBagConstraints gbc_txtTotal = new GridBagConstraints();
		gbc_txtTotal.insets = new Insets(0, 0, 5, 5);
		gbc_txtTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotal.gridx = 4;
		gbc_txtTotal.gridy = 1;
		content.add(txtTotal, gbc_txtTotal);
		txtTotal.setColumns(10);

		txterAo = new JTextField();
		txterAo.setBorder(null);
		txterAo.setFont(new Font("Dialog", Font.BOLD, 16));
		txterAo.setHorizontalAlignment(SwingConstants.RIGHT);
		txterAo.setText("1ER AÑO:");
		GridBagConstraints gbc_txterAo = new GridBagConstraints();
		gbc_txterAo.insets = new Insets(0, 0, 5, 5);
		gbc_txterAo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txterAo.gridx = 1;
		gbc_txterAo.gridy = 2;
		content.add(txterAo, gbc_txterAo);
		txterAo.setColumns(10);

		textH1 = new JLabel();
		textH1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textH1.setForeground(new Color(224, 27, 36));
		textH1.setPreferredSize(new Dimension(100, 50));
		textH1.setMaximumSize(new Dimension(100, 50));
		textH1.setFont(new Font("Dialog", Font.BOLD, 22));
		textH1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textH1 = new GridBagConstraints();
		gbc_textH1.insets = new Insets(0, 0, 5, 5);
		gbc_textH1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textH1.gridx = 2;
		gbc_textH1.gridy = 2;
		content.add(textH1, gbc_textH1);

		textV1 = new JLabel();
		textV1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textV1.setForeground(Color.BLUE);
		textV1.setPreferredSize(new Dimension(100, 50));
		textV1.setMaximumSize(new Dimension(100, 50));
		textV1.setHorizontalAlignment(SwingConstants.RIGHT);
		textV1.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textV1 = new GridBagConstraints();
		gbc_textV1.insets = new Insets(0, 0, 5, 5);
		gbc_textV1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textV1.gridx = 3;
		gbc_textV1.gridy = 2;
		content.add(textV1, gbc_textV1);

		textTOTAL1 = new JLabel();
		textTOTAL1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textTOTAL1.setPreferredSize(new Dimension(100, 50));
		textTOTAL1.setMaximumSize(new Dimension(100, 50));
		textTOTAL1.setHorizontalAlignment(SwingConstants.RIGHT);
		textTOTAL1.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textTOTAL1 = new GridBagConstraints();
		gbc_textTOTAL1.insets = new Insets(0, 0, 5, 5);
		gbc_textTOTAL1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTOTAL1.gridx = 4;
		gbc_textTOTAL1.gridy = 2;
		content.add(textTOTAL1, gbc_textTOTAL1);

		txtdoAo = new JTextField();
		txtdoAo.setBorder(null);
		txtdoAo.setFont(new Font("Dialog", Font.BOLD, 16));
		txtdoAo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtdoAo.setText("2DO AÑO:");
		GridBagConstraints gbc_txtdoAo = new GridBagConstraints();
		gbc_txtdoAo.insets = new Insets(0, 0, 5, 5);
		gbc_txtdoAo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdoAo.gridx = 1;
		gbc_txtdoAo.gridy = 3;
		content.add(txtdoAo, gbc_txtdoAo);
		txtdoAo.setColumns(10);

		textH2 = new JLabel();
		textH2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textH2.setForeground(new Color(224, 27, 36));
		textH2.setPreferredSize(new Dimension(100, 50));
		textH2.setMaximumSize(new Dimension(100, 50));
		textH2.setHorizontalAlignment(SwingConstants.RIGHT);
		textH2.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textH2 = new GridBagConstraints();
		gbc_textH2.insets = new Insets(0, 0, 5, 5);
		gbc_textH2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textH2.gridx = 2;
		gbc_textH2.gridy = 3;
		content.add(textH2, gbc_textH2);

		textV2 = new JLabel();
		textV2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textV2.setForeground(Color.BLUE);
		textV2.setPreferredSize(new Dimension(100, 50));
		textV2.setMaximumSize(new Dimension(100, 50));
		textV2.setHorizontalAlignment(SwingConstants.RIGHT);
		textV2.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textV2 = new GridBagConstraints();
		gbc_textV2.insets = new Insets(0, 0, 5, 5);
		gbc_textV2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textV2.gridx = 3;
		gbc_textV2.gridy = 3;
		content.add(textV2, gbc_textV2);

		textTOTAL2 = new JLabel();
		textTOTAL2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textTOTAL2.setPreferredSize(new Dimension(100, 50));
		textTOTAL2.setMaximumSize(new Dimension(100, 50));
		textTOTAL2.setHorizontalAlignment(SwingConstants.RIGHT);
		textTOTAL2.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textTOTAL2 = new GridBagConstraints();
		gbc_textTOTAL2.insets = new Insets(0, 0, 5, 5);
		gbc_textTOTAL2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTOTAL2.gridx = 4;
		gbc_textTOTAL2.gridy = 3;
		content.add(textTOTAL2, gbc_textTOTAL2);

		txterAo_1 = new JTextField();
		txterAo_1.setBorder(null);
		txterAo_1.setFont(new Font("Dialog", Font.BOLD, 18));
		txterAo_1.setHorizontalAlignment(SwingConstants.RIGHT);
		txterAo_1.setText("3ER AÑO:");
		GridBagConstraints gbc_txterAo_1 = new GridBagConstraints();
		gbc_txterAo_1.insets = new Insets(0, 0, 5, 5);
		gbc_txterAo_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txterAo_1.gridx = 1;
		gbc_txterAo_1.gridy = 4;
		content.add(txterAo_1, gbc_txterAo_1);
		txterAo_1.setColumns(10);

		textH3 = new JLabel();
		textH3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textH3.setForeground(new Color(224, 27, 36));
		textH3.setPreferredSize(new Dimension(100, 50));
		textH3.setMaximumSize(new Dimension(100, 50));
		textH3.setHorizontalAlignment(SwingConstants.RIGHT);
		textH3.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textH3 = new GridBagConstraints();
		gbc_textH3.insets = new Insets(0, 0, 5, 5);
		gbc_textH3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textH3.gridx = 2;
		gbc_textH3.gridy = 4;
		content.add(textH3, gbc_textH3);

		textV3 = new JLabel();
		textV3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textV3.setForeground(Color.BLUE);
		textV3.setPreferredSize(new Dimension(100, 50));
		textV3.setMaximumSize(new Dimension(100, 50));
		textV3.setHorizontalAlignment(SwingConstants.RIGHT);
		textV3.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textV3 = new GridBagConstraints();
		gbc_textV3.insets = new Insets(0, 0, 5, 5);
		gbc_textV3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textV3.gridx = 3;
		gbc_textV3.gridy = 4;
		content.add(textV3, gbc_textV3);

		textTOTAL3 = new JLabel();
		textTOTAL3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textTOTAL3.setPreferredSize(new Dimension(100, 50));
		textTOTAL3.setMaximumSize(new Dimension(100, 50));
		textTOTAL3.setHorizontalAlignment(SwingConstants.RIGHT);
		textTOTAL3.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textTOTAL3 = new GridBagConstraints();
		gbc_textTOTAL3.insets = new Insets(0, 0, 5, 5);
		gbc_textTOTAL3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTOTAL3.gridx = 4;
		gbc_textTOTAL3.gridy = 4;
		content.add(textTOTAL3, gbc_textTOTAL3);

		txttoAo = new JTextField();
		txttoAo.setBorder(null);
		txttoAo.setFont(new Font("Dialog", Font.BOLD, 16));
		txttoAo.setHorizontalAlignment(SwingConstants.RIGHT);
		txttoAo.setText("4TO AÑO:");
		GridBagConstraints gbc_txttoAo = new GridBagConstraints();
		gbc_txttoAo.insets = new Insets(0, 0, 5, 5);
		gbc_txttoAo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttoAo.gridx = 1;
		gbc_txttoAo.gridy = 5;
		content.add(txttoAo, gbc_txttoAo);
		txttoAo.setColumns(10);

		textH4 = new JLabel();
		textH4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textH4.setForeground(new Color(224, 27, 36));
		textH4.setPreferredSize(new Dimension(100, 50));
		textH4.setMaximumSize(new Dimension(100, 50));
		textH4.setHorizontalAlignment(SwingConstants.RIGHT);
		textH4.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textH4 = new GridBagConstraints();
		gbc_textH4.insets = new Insets(0, 0, 5, 5);
		gbc_textH4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textH4.gridx = 2;
		gbc_textH4.gridy = 5;
		content.add(textH4, gbc_textH4);

		textV4 = new JLabel();
		textV4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textV4.setForeground(Color.BLUE);
		textV4.setPreferredSize(new Dimension(100, 50));
		textV4.setMaximumSize(new Dimension(100, 50));
		textV4.setHorizontalAlignment(SwingConstants.RIGHT);
		textV4.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textV4 = new GridBagConstraints();
		gbc_textV4.insets = new Insets(0, 0, 5, 5);
		gbc_textV4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textV4.gridx = 3;
		gbc_textV4.gridy = 5;
		content.add(textV4, gbc_textV4);

		textTOTAL4 = new JLabel();
		textTOTAL4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textTOTAL4.setPreferredSize(new Dimension(100, 50));
		textTOTAL4.setMaximumSize(new Dimension(100, 50));
		textTOTAL4.setHorizontalAlignment(SwingConstants.RIGHT);
		textTOTAL4.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textTOTAL4 = new GridBagConstraints();
		gbc_textTOTAL4.insets = new Insets(0, 0, 5, 5);
		gbc_textTOTAL4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTOTAL4.gridx = 4;
		gbc_textTOTAL4.gridy = 5;
		content.add(textTOTAL4, gbc_textTOTAL4);

		txttoAo_1 = new JTextField();
		txttoAo_1.setBorder(null);
		txttoAo_1.setFont(new Font("Dialog", Font.BOLD, 16));
		txttoAo_1.setHorizontalAlignment(SwingConstants.RIGHT);
		txttoAo_1.setText("5TO AÑO:");
		GridBagConstraints gbc_txttoAo_1 = new GridBagConstraints();
		gbc_txttoAo_1.insets = new Insets(0, 0, 5, 5);
		gbc_txttoAo_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttoAo_1.gridx = 1;
		gbc_txttoAo_1.gridy = 6;
		content.add(txttoAo_1, gbc_txttoAo_1);
		txttoAo_1.setColumns(10);

		textH5 = new JLabel();
		textH5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textH5.setForeground(new Color(224, 27, 36));
		textH5.setPreferredSize(new Dimension(100, 50));
		textH5.setMaximumSize(new Dimension(100, 50));
		textH5.setHorizontalAlignment(SwingConstants.RIGHT);
		textH5.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textH5 = new GridBagConstraints();
		gbc_textH5.insets = new Insets(0, 0, 5, 5);
		gbc_textH5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textH5.gridx = 2;
		gbc_textH5.gridy = 6;
		content.add(textH5, gbc_textH5);

		textV5 = new JLabel();
		textV5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textV5.setForeground(Color.BLUE);
		textV5.setPreferredSize(new Dimension(100, 50));
		textV5.setMaximumSize(new Dimension(100, 50));
		textV5.setHorizontalAlignment(SwingConstants.RIGHT);
		textV5.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textV5 = new GridBagConstraints();
		gbc_textV5.insets = new Insets(0, 0, 5, 5);
		gbc_textV5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textV5.gridx = 3;
		gbc_textV5.gridy = 6;
		content.add(textV5, gbc_textV5);

		textTOTAL5 = new JLabel();
		textTOTAL5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textTOTAL5.setPreferredSize(new Dimension(100, 50));
		textTOTAL5.setMaximumSize(new Dimension(100, 50));
		textTOTAL5.setHorizontalAlignment(SwingConstants.RIGHT);
		textTOTAL5.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textTOTAL5 = new GridBagConstraints();
		gbc_textTOTAL5.insets = new Insets(0, 0, 5, 5);
		gbc_textTOTAL5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTOTAL5.gridx = 4;
		gbc_textTOTAL5.gridy = 6;
		content.add(textTOTAL5, gbc_textTOTAL5);

		txtTotales = new JTextField();
		txtTotales.setBorder(null);
		txtTotales.setFont(new Font("Dialog", Font.BOLD, 16));
		txtTotales.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotales.setText("TOTALES:");
		GridBagConstraints gbc_txtTotales = new GridBagConstraints();
		gbc_txtTotales.insets = new Insets(0, 0, 0, 5);
		gbc_txtTotales.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotales.gridx = 1;
		gbc_txtTotales.gridy = 7;
		content.add(txtTotales, gbc_txtTotales);
		txtTotales.setColumns(10);

		textHTotal = new JLabel();
		textHTotal.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textHTotal.setForeground(new Color(224, 27, 36));
		textHTotal.setPreferredSize(new Dimension(100, 50));
		textHTotal.setMaximumSize(new Dimension(100, 50));
		textHTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		textHTotal.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textHTotal = new GridBagConstraints();
		gbc_textHTotal.insets = new Insets(0, 0, 0, 5);
		gbc_textHTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textHTotal.gridx = 2;
		gbc_textHTotal.gridy = 7;
		content.add(textHTotal, gbc_textHTotal);

		textVTotal = new JLabel();
		textVTotal.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textVTotal.setForeground(Color.BLUE);
		textVTotal.setPreferredSize(new Dimension(100, 50));
		textVTotal.setMaximumSize(new Dimension(100, 50));
		textVTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		textVTotal.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textVTotal = new GridBagConstraints();
		gbc_textVTotal.insets = new Insets(0, 0, 0, 5);
		gbc_textVTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textVTotal.gridx = 3;
		gbc_textVTotal.gridy = 7;
		content.add(textVTotal, gbc_textVTotal);

		textTOTALGENERAL = new JLabel();
		textTOTALGENERAL.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textTOTALGENERAL.setPreferredSize(new Dimension(100, 50));
		textTOTALGENERAL.setMaximumSize(new Dimension(100, 50));
		textTOTALGENERAL.setHorizontalAlignment(SwingConstants.RIGHT);
		textTOTALGENERAL.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_textTOTALGENERAL = new GridBagConstraints();
		gbc_textTOTALGENERAL.insets = new Insets(0, 0, 0, 5);
		gbc_textTOTALGENERAL.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTOTALGENERAL.gridx = 4;
		gbc_textTOTALGENERAL.gridy = 7;
		content.add(textTOTALGENERAL, gbc_textTOTALGENERAL);

		openShowMatricula();
		
	
		

	}

	
	
	
	
	private void openShowMatricula() {
		
		
		//String []annop= {"1ER AÑO", "2DO AÑO", "3ER AÑO", "4TO AÑO CS", "5TO AÑO CS"};
		//String []sexop= {"F", "M"};
		
		DbConnection bd = new DbConnection();
		Statement st;
				try {
					bd.Conectar();
		
		st = bd.getConexion().createStatement();
		String anno = null;
		String sexo = null;
		int[][] total =  new int[6][3];
		
		
		int x;
		
		int i = 0;
		
		for ( x = 1; x < 6; x++) {

			if (x == 1) {
				anno = "1ER AÑO";
			}
			if (x == 2) {
				anno = "2DO AÑO";
			}
			if (x == 3) {
				anno = "3ER AÑO";
			}

			if (x == 4) {
				anno = "4TO AÑO CS";
			}

			if (x == 5) {
				anno = "5TO AÑO CS";
			}

			
			for ( i = 1; i < 3; i++) {
				if (i == 1) {
					sexo = "F";
				}

				if (i == 2) {
					sexo = "M";
				}
			
				
				
				
				
				

				res = st.executeQuery(
						"SELECT COUNT(sexoest)  FROM  estudiantes,ingresos WHERE ingresos.periodoescolar =  '2023-2024' && anoest = '"
								+ anno + "'   &&  sexoest = '" + sexo
								+ "' && status ='I'  &&  estudiantes.cedulaest = ingresos.cedulaest");
				res.next();

			
				
			total[x][i] = res.getInt(1);	
				
			
				 		

			}

			 // 	ACUMULAR LA CANTIDAD DE TODOS LOS FEMENINOS DEL PROCEDO
            totalH = total[x][1] + totalH;

            // 	ACUMULAR LA CANTIDAD DE TODOS LOS MASCULINOS DEL PROCEDO
            totalV = total[x][2] + totalV;
			
            
			
		}
			
		// SE ALACENA EN LOS JTEXTFIELD EL VALOR DEL PROCESO DEL CICLO 
		//  [x]= años    [i] = secc
		
		
		
		textH1.setText(Integer.toString(total[1][1]));
		textV1.setText(Integer.toString(total[1][2]));
		
		textH2.setText(Integer.toString(total[2][1]));
		textV2.setText(Integer.toString(total[2][2]));
		
		textH3.setText(Integer.toString(total[3][1]));
		textV3.setText(Integer.toString(total[3][2]));
		
		textH4.setText(Integer.toString(total[4][1]));
		textV4.setText(Integer.toString(total[4][2]));
		
		textH5.setText(Integer.toString(total[5][1]));
		textV5.setText(Integer.toString(total[5][2]));
		
	textHTotal.setText(Integer.toString(totalH));
	textVTotal.setText(Integer.toString(totalV));
		
	
	// el total de cada año, sumando los femeninos con los masculinos
	
	int total1 = total[1][1] + total[1][2];
	  textTOTAL1.setText(Integer.toString(total1));
	  
	  int total2 = total[2][1] + total[2][2];
	  textTOTAL2.setText(Integer.toString(total2));
	  
	  int total3 = total[3][1] + total[3][2];
	  textTOTAL3.setText(Integer.toString(total3));
	  
	  int total4 = total[4][1] + total[4][2];
	  textTOTAL4.setText(Integer.toString(total4));
	  
	  int total5 = total[5][1] + total[5][2];
	  textTOTAL5.setText(Integer.toString(total5));
	
	
	  int totalGENRAL = totalH + totalV;
	  
	  textTOTALGENERAL.setText(Integer.toString(totalGENRAL));
	 
				
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
