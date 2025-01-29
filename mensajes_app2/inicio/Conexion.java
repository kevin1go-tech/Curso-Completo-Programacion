package inicio;
import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {

	public Connection get_conection() {
		Connection connection = null; 
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","marisol","admin1234");
			if (connection != null) {
				System.out.println("Conexion exitosa");
			}
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		return connection;
	}
}
