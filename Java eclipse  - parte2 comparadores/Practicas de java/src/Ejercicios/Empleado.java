package Ejercicios;

import java.util.Comparator;

public class Empleado implements Comparable<Empleado> {
    private String nombre;
    private double salario;
    private int antigüedad;

    // Constructor
    public Empleado(String nombre, double salario, int antigüedad) {
        this.nombre = nombre;
        this.salario = salario;
        this.antigüedad = antigüedad;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public int getAntigüedad() {
        return antigüedad;
    }

    // Implementación del método compareTo para ordenar por salario en orden descendente
    @Override
    public int compareTo(Empleado otro) {
        // Ordenamos en orden descendente por salario
        return Double.compare(otro.salario, this.salario);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", antigüedad=" + antigüedad +
                '}';
    }

    // Comparator para desempatar por nombre en caso de igual salario
    public static Comparator<Empleado> desempatarPorNombre = new Comparator<Empleado>() {
        @Override
        public int compare(Empleado e1, Empleado e2) {
            // Si los salarios son iguales, desempatar por nombre alfabéticamente
            return e1.nombre.compareTo(e2.nombre);
        }
    };
}
