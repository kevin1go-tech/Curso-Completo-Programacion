package InterfacesGraficas;

/*
 * Hacer un programa que le pida al usuario su nombre, su edad, y su nota
 * Mostrar un mensaje de Bienvenido nombre, usted es(Mayor/menor) de edad
 * Mostrar una ventanilla de alerta que indique si esta aprobado o desaprobado(JOptionPlane)
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Practica_Interfaz2 {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtNota;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practica_Interfaz2 window = new Practica_Interfaz2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Practica_Interfaz2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Etiqueta para el nombre
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 30, 100, 20);
		frame.getContentPane().add(lblNombre);
		
		// Campo de texto para el nombre
		txtNombre = new JTextField();
		txtNombre.setBounds(130, 30, 200, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		// Etiqueta para la edad
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(30, 70, 100, 20);
		frame.getContentPane().add(lblEdad);
		
		// Campo de texto para la edad
		txtEdad = new JTextField();
		txtEdad.setBounds(130, 70, 200, 20);
		frame.getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		// Etiqueta para la nota
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setBounds(30, 110, 100, 20);
		frame.getContentPane().add(lblNota);
		
		// Campo de texto para la nota
		txtNota = new JTextField();
		txtNota.setBounds(130, 110, 200, 20);
		frame.getContentPane().add(txtNota);
		txtNota.setColumns(10);
		
		// Botón para procesar la información
		JButton btnProcesar = new JButton("Aceptar");
		btnProcesar.setBounds(150, 160, 130, 30);
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener los datos ingresados por el usuario
				String nombre = txtNombre.getText();
				String edadStr = txtEdad.getText();
				String notaStr = txtNota.getText();
				
				// Verificar que los datos sean válidos
				try {
					int edad = Integer.parseInt(edadStr);
					double nota = Double.parseDouble(notaStr);
					
					// Determinar si es mayor o menor de edad
					String mensajeEdad = (edad >= 18) ? "Mayor" : "Menor";
					
					// Mostrar el mensaje de bienvenida
					JOptionPane.showMessageDialog(frame, "Bienvenido " + nombre + ", usted es " + mensajeEdad + " de edad.");
					
					// Verificar si está aprobado o desaprobado
					String mensajeNota = (nota >= 6) ? "Aprobado" : "Desaprobado";
					
					// Mostrar el estado de la nota
					JOptionPane.showMessageDialog(frame, "Estado de la nota: " + mensajeNota);
					
				} catch (NumberFormatException ex) {
					// Si hay un error en la conversión, mostrar un mensaje de error
					JOptionPane.showMessageDialog(frame, "Por favor ingrese valores válidos para la edad y la nota.");
				}
			}
		});
		frame.getContentPane().add(btnProcesar);
	}
}
