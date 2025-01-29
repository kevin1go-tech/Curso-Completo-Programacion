package inicio;

import java.util.Scanner;

/*
 * Capa de servicios que recibe los datos del menu y llama a la capa DAO para efectuar las opeeraciones en la BD
 * 
 * */

public class mensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String msj = sc.nextLine();
        
        System.out.println("Ingresa el autor");
        String autor = sc.nextLine();
        
        Mensajes mensaje = new Mensajes(msj,autor);
        MensajesDAO.crearMensajeDB(mensaje);
    }
    
    public static void listarMensajes(){
        
    }
    public static void borrarMensaje(){
        
    }
    
    public static void editarMensaje(){
        
    }
    
}
