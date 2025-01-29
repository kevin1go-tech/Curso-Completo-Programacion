package inicio;

/*
 * DATA ACCESS OBJECT
 * Esta clase se comunica con la BD para realizar las operaciones
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
        try {
			Connection c = ConnectDatabase.getConnection();
			PreparedStatement ps = null;
			try {
				String query = "INSERT INTO `mensajes` ( `mensaje`, `autor_mensaje`) VALUES ( ?, ?)";
				ps = c.prepareStatement(query);
				ps.setString(1,mensaje.getMensaje());
				ps.setString(2,mensaje.getAutor_mensaje());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Mensaje creado correctamente", "Exitoso",JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Mensaje creado correctamente");
			}
			catch(Exception e) {
				System.out.println(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
        
        
    }
    
    public static void leerMensajesDB(){
        
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje){
        
    }
    
}

