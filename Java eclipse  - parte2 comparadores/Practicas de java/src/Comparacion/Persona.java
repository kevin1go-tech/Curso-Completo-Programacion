package Comparacion;

public class Persona {
    // Atributos de la clase Persona
    private String nombre;
    private int edad;
    
    public int compareTo(Persona other) {
    	if (edad > other.getEdad()) {
    		return 0;
    	}else
    		return -0;   		
    }

    // Constructor de la clase Persona
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos getter para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Método para comparar si dos personas son iguales
    public boolean esIgual(Persona otraPersona) {
        return this.nombre.equals(otraPersona.getNombre()) && this.edad == otraPersona.getEdad();
    }
}
