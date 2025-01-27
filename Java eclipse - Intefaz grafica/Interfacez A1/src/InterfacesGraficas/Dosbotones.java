package InterfacesGraficas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JEditorPane;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Dosbotones {

	private JFrame frmNombres;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dosbotones window = new Dosbotones();
					window.frmNombres.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dosbotones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNombres = new JFrame();
		frmNombres.setBounds(100, 100, 331, 323);
		frmNombres.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNombres.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Boton 4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Presionaste el boton 4", "Boton 4", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Presiona los 4 botones y mira el resultado");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(38, 22, 240, 35);
		frmNombres.getContentPane().add(lblNewLabel);
		btnNewButton.setBounds(176, 146, 126, 48);
		frmNombres.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Boton 3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Presionaste el boton 3", "Boton 3", JOptionPane.QUESTION_MESSAGE);
			}
		});
		btnNewButton_1.setBounds(176, 77, 126, 48);
		frmNombres.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Boton 1");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Presionaste el boton 1", "Boton 1", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_2.setBounds(10, 77, 126, 48);
		frmNombres.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Boton 2");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Presionaste el boton 2", "Boton 2", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButton_3.setBounds(10, 146, 126, 48);
		frmNombres.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese su nombre: ");
		lblNewLabel_1.setBounds(10, 205, 105, 14);
		frmNombres.getContentPane().add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setText("nombre");
		txtNombre.setBounds(10, 222, 292, 20);
		frmNombres.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Aceptar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(108, 253, 89, 23);
		frmNombres.getContentPane().add(btnNewButton_4);
	}
}
