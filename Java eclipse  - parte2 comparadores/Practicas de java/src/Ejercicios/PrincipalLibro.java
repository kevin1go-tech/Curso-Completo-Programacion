package Ejercicios;

import java.util.ArrayList;
import java.util.Collections;

public class PrincipalLibro {
    public static void main(String[] args) {
        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(new Libro("El Quijote", "Miguel de Cervantes", 1605));
        libros.add(new Libro("Cien A�os de Soledad", "Gabriel Garc�a M�rquez", 1967));
        libros.add(new Libro("Don Juan Tenorio", "Tirso de Molina", 1630));

        // Ordenar por t�tulo alfab�ticamente usando Comparable
        Collections.sort(libros);

        System.out.println("Libros ordenados por t�tulo:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
}
