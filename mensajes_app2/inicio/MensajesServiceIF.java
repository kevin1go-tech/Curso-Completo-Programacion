package inicio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MensajesServiceIF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMensaje;
	private JTextField textFieldAutor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MensajesServiceIF frame = new MensajesServiceIF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MensajesServiceIF() {
		setTitle("Crear mensaje");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMensaje = new JLabel("Mensaje: ");
		lblMensaje.setBounds(69, 46, 52, 13);
		contentPane.add(lblMensaje);
		
		textFieldMensaje = new JTextField();
		textFieldMensaje.setBounds(141, 43, 217, 19);
		contentPane.add(textFieldMensaje);
		textFieldMensaje.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(76, 95, 45, 13);
		contentPane.add(lblAutor);
		
		textFieldAutor = new JTextField();
		textFieldAutor.setBounds(141, 92, 217, 19);
		contentPane.add(textFieldAutor);
		textFieldAutor.setColumns(10);
		
		JButton btnCrearMensaje = new JButton("Crear Mensaje");
		btnCrearMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msj = textFieldMensaje.getText();
				String autor = textFieldAutor.getText();
				
		        Mensajes mensaje = new Mensajes(msj,autor);
		        MensajesDAO.crearMensajeDB(mensaje);
				
			}
		});
		btnCrearMensaje.setBounds(64, 196, 133, 21);
		contentPane.add(btnCrearMensaje);
	}
}
