package Pruebas_Bases_Datos;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class Ejemplodatabase {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");

            Connection con = DriverManager.getConnection("jdbc:sqlite:BaseA.db");
            
            if (con != null) {
                System.out.println("Se creó y/o abrió la base de datos.");
            }

            Statement stmt = con.createStatement();

            // Crear tabla de Alumnos con claves foráneas a Cursos y Géneros
            stmt.execute("CREATE TABLE alumnos ("
                    + "Alumno_id INTEGER PRIMARY KEY, "
                    + "name TEXT, "
                    + "age INTEGER, "
                    + "Curso_id INTEGER, "
                    + "Genero_id INTEGER, "
                    + "FOREIGN KEY(Curso_id) REFERENCES cursos(Curso_id), "
                    + "FOREIGN KEY(Genero_id) REFERENCES generos(Genero_id));");
            System.out.println("Creación de tabla Alumnos exitosa");

            stmt.execute("INSERT INTO alumnos VALUES (1, 'Carlitos', 20, 1, 1);");
            stmt.execute("INSERT INTO alumnos VALUES (2, 'Bety', 19, 2, 2);");
            stmt.execute("INSERT INTO alumnos VALUES (3, 'Mario', 17, 3, 1);");
            stmt.execute("INSERT INTO alumnos VALUES (4, 'Beky', 15, 4, 2);");
            stmt.execute("INSERT INTO alumnos VALUES (5, 'Juan', 40, 5, 1);");
            stmt.execute("INSERT INTO alumnos VALUES (6, 'Beatriz', 100, 6, 2);");
            stmt.execute("INSERT INTO alumnos VALUES (7, 'Amanda', 23, 7, 1);");
            stmt.execute("INSERT INTO alumnos VALUES (8, 'Jorge', 80, 8, 2);");
            stmt.execute("INSERT INTO alumnos VALUES (9, 'Pedro', 20, 9, 1);");
            stmt.execute("INSERT INTO alumnos VALUES (10, 'Bela', 22, 10, 2);");
            stmt.execute("INSERT INTO alumnos VALUES (11, 'Kangu', 20, 1, 1);");
            stmt.execute("INSERT INTO alumnos VALUES (12, 'Anna', 28, 2, 2);");
            stmt.execute("INSERT INTO alumnos VALUES (13, 'Lanna', 17, 3, 1);");
            stmt.execute("INSERT INTO alumnos VALUES (14, 'Aaron', 31, 4, 2);");

            // Crear tabla de Cursos
            stmt.execute("CREATE TABLE cursos (Curso_id INTEGER PRIMARY KEY, name TEXT);");
            System.out.println("Creación de tabla Cursos exitosa");

            stmt.execute("INSERT INTO cursos VALUES (1, 'Matematicas');");
            stmt.execute("INSERT INTO cursos VALUES (2, 'Ciencias');");
            stmt.execute("INSERT INTO cursos VALUES (3, 'Fisica');");
            stmt.execute("INSERT INTO cursos VALUES (4, 'Quimica');");
            stmt.execute("INSERT INTO cursos VALUES (5, 'Geometria');");
            stmt.execute("INSERT INTO cursos VALUES (6, 'Gastronomia');");
            stmt.execute("INSERT INTO cursos VALUES (7, 'Programacion');");
            stmt.execute("INSERT INTO cursos VALUES (8, 'Historia');");
            stmt.execute("INSERT INTO cursos VALUES (9, 'Turismo');");
            stmt.execute("INSERT INTO cursos VALUES (10, 'Ingenieria');");

            // Crear tabla de Géneros
            stmt.execute("CREATE TABLE generos (Genero_id INTEGER PRIMARY KEY, tipo TEXT);");
            System.out.println("Creación de tabla Generos exitosa");

            stmt.execute("INSERT INTO generos VALUES (1, 'Masculino');");
            stmt.execute("INSERT INTO generos VALUES (2, 'Femenino');");

            System.out.println("Inserción de datos exitosa.");

            ResultSet rsAlumnos = stmt.executeQuery("SELECT * FROM alumnos;");
            System.out.println("Alumnos:");
            while (rsAlumnos.next()) {
                System.out.println(rsAlumnos.getInt(1) + " " + rsAlumnos.getString(2) + " " 
                        + rsAlumnos.getInt(3) + " " + rsAlumnos.getInt(4) + " " 
                        + rsAlumnos.getInt(5));
            }

            ResultSet rsCursos = stmt.executeQuery("SELECT * FROM cursos;");
            System.out.println("Cursos:");
            while (rsCursos.next()) {
                System.out.println(rsCursos.getInt(1) + " " + rsCursos.getString(2));
            }

            ResultSet rsGeneros = stmt.executeQuery("SELECT * FROM generos;");
            System.out.println("Generos:");
            while (rsGeneros.next()) {
                System.out.println(rsGeneros.getInt(1) + " " + rsGeneros.getString(2));
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
