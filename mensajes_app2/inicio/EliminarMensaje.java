package inicio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class EliminarMensaje extends JFrame {

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
					EliminarMensaje frame = new EliminarMensaje();
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
	public EliminarMensaje() {
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
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarMensaje();
			}
		});
		btnEliminar.setBounds(392, 49, 85, 21);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarMensaje();
			}
		});
		btnModificar.setBounds(487, 49, 85, 21);
		contentPane.add(btnModificar);

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
	
	 private void eliminarMensaje() {
	        int selectedRow = tableMensajes.getSelectedRow();

	        if (selectedRow == -1) {
	            JOptionPane.showMessageDialog(this, "Selecciona un mensaje para eliminar.");
	            return;
	        }

	        String idMensaje = tableMensajes.getValueAt(selectedRow, 0).toString();

	        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este mensaje?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

	        if (confirm == JOptionPane.YES_OPTION) {
	            String query = "DELETE FROM mensajes WHERE id_mensaje = ?";

	            try (Connection con = ConnectDatabase.getConnection();
	                 PreparedStatement ps = con.prepareStatement(query)) {

	                ps.setString(1, idMensaje);

	                int rowsAffected = ps.executeUpdate();

	                if (rowsAffected > 0) {
	                    JOptionPane.showMessageDialog(this, "Mensaje eliminado exitosamente.");
	                    mostrarTabla((String) ((JComboBox) contentPane.getComponent(1)).getSelectedItem(), tableMensajes);
	                }

	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	 }
	 
	 
	 private void modificarMensaje() {
	        int selectedRow = tableMensajes.getSelectedRow();

	        if (selectedRow == -1) {
	            JOptionPane.showMessageDialog(this, "Selecciona un mensaje para editar.");
	            return;
	        }

	        String idMensaje = tableMensajes.getValueAt(selectedRow, 0).toString();
	        String contenidoActual = tableMensajes.getValueAt(selectedRow, 1).toString();

	        String nuevoContenido = JOptionPane.showInputDialog(this, "Editar mensaje:", contenidoActual);

	        if (nuevoContenido != null && !nuevoContenido.trim().isEmpty()) {
	            String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";

	            try (Connection con = ConnectDatabase.getConnection();
	                 PreparedStatement ps = con.prepareStatement(query)) {

	                ps.setString(1, nuevoContenido);
	                ps.setString(2, idMensaje);

	                int rowsAffected = ps.executeUpdate();

	                if (rowsAffected > 0) {
	                    JOptionPane.showMessageDialog(this, "Mensaje editado exitosamente.");
	                    mostrarTabla((String) ((JComboBox) contentPane.getComponent(1)).getSelectedItem(), tableMensajes);
	                }

	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }


}
