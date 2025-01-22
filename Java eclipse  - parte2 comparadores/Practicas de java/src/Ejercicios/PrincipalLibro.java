package Ejercicios;

import java.util.ArrayList;
import java.util.Collections;

public class PrincipalLibro {
    public static void main(String[] args) {
        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(new Libro("El Quijote", "Miguel de Cervantes", 1605));
        libros.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967));
        libros.add(new Libro("Don Juan Tenorio", "Tirso de Molina", 1630));

        // Ordenar por título alfabéticamente usando Comparable
        Collections.sort(libros);

        System.out.println("Libros ordenados por título:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
}
