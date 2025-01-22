package Comparacion;

public class Comparador {
    // Método que compara dos personas usando compareTo
    public String comparar(Persona2 personaA, Persona2 personaB) {
        int resultadoComparacion = personaA.compareTo(personaB);
        
        // Si el resultado de compareTo es mayor a 0, persona1 es mayor
        if (resultadoComparacion > 0) {
            return personaA.getNombre() + " " + personaB.getApellido() + " es mayor.";
        }
        // Si el resultado de compareTo es menor a 0, persona2 es mayor
        else if (resultadoComparacion < 0) {
            return personaB.getNombre() + " " + personaA.getApellido() + " es mayor.";
        }
        // Si son iguales
        else {
            return "Ambas personas son iguales.";
        }
    }
}
