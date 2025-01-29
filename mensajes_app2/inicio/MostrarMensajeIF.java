package inicio;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class MostrarMensajeIF extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableMensajes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarMensajeIF frame = new MostrarMensajeIF();
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
	public MostrarMensajeIF() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400); // Ajusta el tamaño de la ventana
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAutor = new JLabel("Autor: ");
		lblAutor.setBounds(96, 53, 50, 13);
		contentPane.add(lblAutor);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(162, 49, 200, 21);
		llenarComboBox(comboBox);
		contentPane.add(comboBox);

		// Crear JTable y JScrollPane
		tableMensajes = new JTable();
		JScrollPane scrollPane = new JScrollPane(tableMensajes);
		scrollPane.setBounds(50, 100, 500, 200); // Dimensiones adecuadas
		contentPane.add(scrollPane);

		// Añadir ActionListener al JComboBox
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccionado = (String) comboBox.getSelectedItem();
				System.out.println("Autor seleccionado: " + seleccionado);
				mostrarTabla(seleccionado, tableMensajes);
			}
		});
	}

	public static void mostrarTabla(String autor, JTable tabla) {
	    String query = "SELECT * FROM mensajes WHERE autor_mensaje = '" + autor + "'";
	    
	    try (Connection con = ConnectDatabase.getConnection();
	         Statement stm = con.createStatement();
	         ResultSet rs = stm.executeQuery(query)) {

	        // Obtener metadatos de las columnas
	        ResultSetMetaData metaData = rs.getMetaData();
	        int columnCount = metaData.getColumnCount();

	        // Crear modelo para la tabla
	        DefaultTableModel model = new DefaultTableModel();

	        // Añadir nombres de columnas al modelo
	        for (int i = 1; i <= columnCount; i++) {
	            model.addColumn(metaData.getColumnName(i));
	        }

	        // Añadir filas al modelo
	        while (rs.next()) {
	            Object[] row = new Object[columnCount];
	            for (int i = 1; i <= columnCount; i++) {
	                row[i - 1] = rs.getObject(i);
	            }
	            model.addRow(row);
	        }

	        // Establecer modelo en la tabla
	        tabla.setModel(model);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	private void llenarComboBox(JComboBox<String> comboBox) {
	    String query = "SELECT DISTINCT autor_mensaje FROM mensajes";
	    try (Connection conn = ConnectDatabase.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(query)) {

	        while (rs.next()) {
	            String nombre = rs.getString("autor_mensaje");
	            comboBox.addItem(nombre);
	            System.out.println("Cargando autor: " + nombre);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
