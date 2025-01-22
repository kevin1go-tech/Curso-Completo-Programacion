package Comparacion;

public class Persona2 implements Comparable<Persona2> {
    private String nombre;
    private String apellido;
    private int edad;

    public Persona2(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public int compareTo(Persona2 other) {
        int resultadoNombre = this.nombre.compareTo(other.getNombre());
        if (resultadoNombre != 0) {
            return resultadoNombre; 
        }

        int resultadoApellido = this.apellido.compareTo(other.getApellido());
        if (resultadoApellido != 0) {
            return resultadoApellido; 
        }

        return Integer.compare(this.edad, other.getEdad());
    }

    // Método toString para mostrar la información de la persona
    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + edad + " años)";
    }
}
