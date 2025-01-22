package Comparacion;

public class MainPersona {
    public static void main(String[] args) {
        // Instanciando dos objetos de tipo Persona
        Persona persona1 = new Persona("Juan", 25);
        Persona persona2 = new Persona("Maria", 30);

       int comparation = persona1.compareTo(persona2);
       if(comparation==0) {
    	   System.out.println("Ambos son iguales");
       }else if(comparation > 0) {
    	   System.out.println("El mayor es: " +persona1.getNombre());
       }else {
    	   System.out.println("El mayor es:" +persona2.getNombre());
       }
    }
}

/*
 * Comparar dos personas, una es mayor si el nombre del mayor
 * si tiene el mismo nombre, verificar apellido
 * si tiene el mismo apellido, verificar la edad
 */

