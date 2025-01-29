package inicio;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectDatabase {
    private static Connection myConnection;

    ConnectDatabase() {
    }

    public static Connection getConnection() throws SQLException {
        if (myConnection == null || myConnection.isClosed()) {
            try {
            	myConnection = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com/sql10760161","sql10760161","mAwbvAcgk3");
    			if (myConnection != null) {
    				System.out.println("Conexion exitosa");
    			}
            }
    		catch(Exception e){
    			System.out.println(e);
    		
        }
        }
        return myConnection;
    }

}