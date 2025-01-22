package Ejercicios;

import java.util.Comparator;

public class Estudiante implements Comparable<Estudiante> {
    private String nombre;
    private double nota;
    private int edad;

    // Constructor
    public Estudiante(String nombre, double nota, int edad) {
        this.nombre = nombre;
        this.nota = nota;
        this.edad = edad;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    public int getEdad() {
        return edad;
    }

    // Implementación del método compareTo para ordenar por nombre (alfabéticamente)
    @Override
    public int compareTo(Estudiante otro) {
        return this.nombre.compareTo(otro.nombre);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                ", edad=" + edad +
                '}';
    }

    // Comparator para ordenar por nota
    public static Comparator<Estudiante> ordenarPorNota = new Comparator<Estudiante>() {
        @Override
        public int compare(Estudiante e1, Estudiante e2) {
            return Double.compare(e1.nota, e2.nota);
        }
    };

    // Comparator para ordenar por edad
    public static Comparator<Estudiante> ordenarPorEdad = new Comparator<Estudiante>() {
        @Override
        public int compare(Estudiante e1, Estudiante e2) {
            return Integer.compare(e1.edad, e2.edad);
        }
    };
}
