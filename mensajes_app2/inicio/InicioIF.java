package inicio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioIF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioIF frame = new InicioIF();
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
	public InicioIF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnCrearMensaje = new JButton("Crear Mensaje");
		btnCrearMensaje.setBounds(156, 38, 115, 21);
		btnCrearMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensajesServiceIF ms = new MensajesServiceIF();
				ms.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		
		JButton btnMostrarMensajes = new JButton("Mostrar Mensajes");
		btnMostrarMensajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarMensajeIF ms = new MostrarMensajeIF();
				ms.setVisible(rootPaneCheckingEnabled);
			}
		});
		btnMostrarMensajes.setBounds(156, 69, 115, 21);
		contentPane.add(btnMostrarMensajes);
		contentPane.add(btnCrearMensaje);
	}

}
