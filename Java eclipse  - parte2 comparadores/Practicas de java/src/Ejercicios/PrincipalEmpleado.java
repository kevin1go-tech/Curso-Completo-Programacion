package Ejercicios;

import java.util.ArrayList;
import java.util.Collections;

public class PrincipalEmpleado {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("Carlos", 5000, 5));
        empleados.add(new Empleado("Ana", 4500, 7));
        empleados.add(new Empleado("Luis", 5000, 3));

        // Ordenar por salario descendente, desempatar por nombre ascendente
        Collections.sort(empleados);
        Collections.sort(empleados, Empleado.desempatarPorNombre);  // Para desempatar por nombre

        System.out.println("Empleados ordenados:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }
}
