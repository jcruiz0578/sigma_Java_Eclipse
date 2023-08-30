package jcruiz.views;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Informacion extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Informacion() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		panel_1.add(btnNewButton_2);

		JLabel lblBienvenidos = new JLabel("Bienvenidos");
		lblBienvenidos.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 42));
		panel.add(lblBienvenidos, BorderLayout.NORTH);

	}

}
