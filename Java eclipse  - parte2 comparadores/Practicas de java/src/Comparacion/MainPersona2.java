package Comparacion;

public class MainPersona2 {
    public static void main(String[] args) {
        // Crear dos objetos Persona
        Persona2 personaA = new Persona2("Carlos", "Gomez", 30);
        Persona2 personaB = new Persona2("Carlos", "Martinez", 25);

        // Crear el objeto Comparador
        Comparador comparador = new Comparador();

        // Comparar las dos personas
        String resultado = comparador.comparar(personaA, personaB);

        // Mostrar el resultado
        System.out.println(resultado);
    }
}
