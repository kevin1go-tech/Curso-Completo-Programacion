package Ejercicios;

import java.util.ArrayList;
import java.util.Collections;

public class PrincipalEstudiante {
    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Juan", 8.5, 20));
        estudiantes.add(new Estudiante("Ana", 9.0, 22));
        estudiantes.add(new Estudiante("Luis", 7.5, 19));

        // Ordenar por nombre usando Comparable (por defecto)
        Collections.sort(estudiantes);
        System.out.println("Ordenados por nombre:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }

        // Ordenar por nota usando Comparator
        Collections.sort(estudiantes, Estudiante.ordenarPorNota);
        System.out.println("\nOrdenados por nota:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }

        // Ordenar por edad usando Comparator
        Collections.sort(estudiantes, Estudiante.ordenarPorEdad);
        System.out.println("\nOrdenados por edad:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }
}
